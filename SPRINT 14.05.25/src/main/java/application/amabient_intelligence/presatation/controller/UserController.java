package application.amabient_intelligence.presatation.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.amabient_intelligence.logic.boundary.UserBoundary;
import application.amabient_intelligence.logic.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = { "/ambient-intelligence" })
public class UserController {
	private UserService userService;

	public UserController(UserService userupdateservice) {
		this.userService = userupdateservice;
	}

	@PostMapping(path = { "/users" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public UserBoundary createUser(@RequestBody UserBoundary user) {
		return this.userService.createUser(user);
	}

	@PutMapping(path = { "/users/{systemID}/{userEmail}" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void updateUser(@PathVariable("systemID") String systemId, @PathVariable("userEmail") String userEmail,
			@RequestBody UserBoundary update) {
		this.userService.updateUser(systemId, userEmail, update);
	}

	@GetMapping(path = { "/users/login/{systemID}/{userEmail}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserBoundary getSingleInstance(@PathVariable("systemID") String systemId,
			@PathVariable("userEmail") String email) {
		return this.userService.login(systemId, email);
	}

	@GetMapping(path = { "/admin/users" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<UserBoundary> exportAllUsers() {
		return this.userService.getAllUsers();
	}

	@DeleteMapping(path = { "/admin/users" })
	public void deleteAllUsers() {
		this.userService.deleteAllUsers();
	}
}
