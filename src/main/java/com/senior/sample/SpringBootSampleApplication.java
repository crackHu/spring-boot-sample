package com.senior.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "hello docker";
	}

	@GetMapping("/{name}")
	public String hello(@PathVariable String name) {
		return "hello " + getUser(name);
	}
	
	@Cacheable
	public User getUser(String name) {
		User user = new User(name, "aa", "aa123456");
	    System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
	    return user;
	}

	
	
}
