package com.senior.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{name}")
	public String hello(@PathVariable String name) {
		return "hello " + userService.getUser(name);
	}
	
	@GetMapping("/err")
	@ResponseStatus(HttpStatus.CONFLICT)
	public void err() {
		throw new ConcurrencyFailureException("test err");
	}
}
