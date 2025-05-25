package demo.controller;

import demo.boundary.UserBoundary;
import demo.boundary.CommandBoundary;
import demo.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambient-intelligence/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @DeleteMapping("/users")
    public void deleteAllUsers() {
        adminService.deleteAllUsers();
    }

    @DeleteMapping("/objects")
    public void deleteAllObjects() {
        adminService.deleteAllObjects();
    }

    @DeleteMapping("/commands")
    public void deleteAllCommands() {
        adminService.deleteAllCommands();
    }

    @GetMapping("/users")
    public List<UserBoundary> exportAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/commands")
    public List<CommandBoundary> exportAllCommands() {
        return adminService.getAllCommands();
    }
}
