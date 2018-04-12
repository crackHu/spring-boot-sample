package com.senior.sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senior.sample.domain.Travelrecord;
import com.senior.sample.service.TravelrecordService;

@RestController
@SpringBootApplication
public class SpringBootSampleApplication {

	@Autowired
	private TravelrecordService service;
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	public static void main(String[] args) {
		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "hello docker14";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/redis/queue")
	public String queue() {
		redisTemplate.opsForList().leftPush("queue", 1);
		redisTemplate.opsForList().leftPush("queue", 2);
		Object rightPop = redisTemplate.opsForList().rightPop("queue");
		return rightPop.toString();
	}

	@GetMapping("/mycat/find-all")
	public List<Travelrecord> mycatFindAll() {
		StringBuilder all = new StringBuilder();
		service.findAll().forEach(salesman -> all.append(String.format("%s\n", salesman)));
		return service.findAll();
	}

	@GetMapping("/mycat/save")
	public String mycatSave() {
		Travelrecord salesman = new Travelrecord();
		salesman.setName("电风扇" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		Long time = System.currentTimeMillis();
		salesman.setPhone(time.toString());
		Travelrecord save = service.save(salesman);
		return save.toString();
	}
}


