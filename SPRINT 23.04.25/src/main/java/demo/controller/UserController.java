package demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.boundary.NewUserBoundary;
import demo.boundary.UserBoundary;
import demo.service.UserService;

@RestController
@RequestMapping(path = { "/users" })
public class UserController {
	private UserService userupdateservice;

	public UserController(UserService userupdateservice) {
		this.userupdateservice = userupdateservice;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserBoundary createUser(@RequestBody NewUserBoundary user) {
		System.err.println("createUser(" + user + ")");
		return this.userupdateservice.createUser(user);
	}

	@PutMapping(path = { "/{systemID}/{email}" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void updateUser(@PathVariable("systemID") String systemId, @PathVariable("email") String userEmail,
			@RequestBody UserBoundary update) {
		this.userupdateservice.updateUser(systemId, userEmail, update);
	}

	@GetMapping(path = { "/{systemID}/{email}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserBoundary getSingleInstance(@PathVariable("systemID") String systemId,
			@PathVariable("email") String email) {
		return this.userupdateservice.getUser(systemId, email).orElseThrow(
				() -> new RuntimeException("Could not find user with id: " + systemId + " and email: " + email));
	}

}
