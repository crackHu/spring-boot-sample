package com.senior.sample;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.senior.sample.domain.Travelrecord;
import com.senior.sample.service.TravelrecordService;

@RestController
@SpringBootApplication
public class SpringBootSampleApplication {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TravelrecordService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "hello docker";
	}

	@GetMapping("/redis/{name}")
	public String hello(@PathVariable String name) {
		return "hello " + userService.getUser(name);
	}

	@GetMapping("/mycat/find-all")
	public String mycatFindAll() {
		StringBuilder all = new StringBuilder();
		service.findAll().forEach(salesman -> all.append(String.format("%s\n", salesman)));
		return all.toString();
	}
	
	@GetMapping("/mycat/save")
	public String mycatSave() {
		Travelrecord salesman = new Travelrecord();
		salesman.setName("电风扇");
		Long time = new Date().getTime();
		salesman.setPhone(time.toString());
		Travelrecord save = service.save(salesman);
		return save.toString();
	}
}
