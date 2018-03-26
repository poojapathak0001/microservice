package com.main.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.main.modal.UserInformation;
import com.main.service.UserRegistrationService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RegistrationController {

	@Autowired
	UserRegistrationService userService;

	@GetMapping("/register")
	@HystrixCommand(fallbackMethod = "fallbackGetAllRegisteredUserInformationFails")
	public List<UserInformation> getAllRegisteredUserInformation() {
		return userService.getAllRegisteredUserInformation();
	}

	public List<UserInformation> fallbackGetAllRegisteredUserInformationFails() {
		return Arrays.asList(new UserInformation("default", "default", "default", "default"));
	}

	@GetMapping("/register/{id}")
	@HystrixCommand(fallbackMethod = "fallbackGetUserInformationFails")
	public Optional<UserInformation> getUserInformation(@PathVariable String id) {
		return userService.getUserInformation(id);
	}

	public Optional<UserInformation> fallbackGetUserInformationFails() {
	UserInformation user= new UserInformation("default", "default", "default","default" );
	return Optional.of(user);
	}

	@PostMapping("/register")
	@HystrixCommand(fallbackMethod = "fallbackAddUserInformationFails")
	// adding validation using @valid
	public ResponseEntity<Object> addUserInformation(@Valid @RequestBody UserInformation dataOfUserInBody) {
		userService.addUserInformation(dataOfUserInBody);
		// this is added to give a response that the uri that is going to be created is
		// successfully created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dataOfUserInBody.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	public ResponseEntity<Object> fallbackAddUserInformationFails(@Valid @RequestBody UserInformation dataOfUserInBody) {
		return null;
	}

	@PutMapping("/register/{id}")
	@HystrixCommand(fallbackMethod = "fallbackModifyUserInformationFails")
	public String modifyUserInformation(@RequestBody UserInformation dataOfUserInBody) {
		userService.modifyUserInformation(dataOfUserInBody);
		return "topic updated";
	}

	public String fallbackModifyUserInformationFails() {
		return "Cannot Update User";
	}

	@DeleteMapping("/register/{id}")
	@HystrixCommand(fallbackMethod="fallbackDeleteUserInformationFails")
	public String deleteUserInformation(@PathVariable String id) {
		userService.deleteUserInformation(id);
		return "user deleted";
	}

	public String fallbackDeleteUserInformationFails() {
		return "Cannot Delete User";
	}

}
