package org.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Response;

import org.login.module.UserLoginBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {
	
	//get one user by id
	@GetMapping("/users/{email}/{password}")
	public UserLoginBean getUser(@PathVariable String email,
			@PathVariable String password) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("email", email);
		uriVariables.put("password", password);
		
		ResponseEntity<UserLoginBean> responseEntity = new RestTemplate().getForEntity("localhost:8083/users/email/{email}/password/{password}", UserLoginBean.class, uriVariables);
		
		UserLoginBean response = responseEntity.getBody();
		
		return new UserLoginBean(response.getEmail(), response.getPassword() );
		
	}

}