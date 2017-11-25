package com.senior.sample;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Cacheable("user")
	public User getUser(String name) {
		return new User(name);
	}

}
