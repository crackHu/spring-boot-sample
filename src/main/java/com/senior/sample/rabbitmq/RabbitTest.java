package com.senior.sample.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

	@Autowired
	private HelloSender1 helloSender1;
	@Autowired
	private HelloSender1 helloSender2;

	@PostMapping("/hello")
	public void hello() {
		helloSender1.send("hello1");
	}

	/**
	 * 单生产者-多消费者
	 */
	@PostMapping("/oneToMany")
	public void oneToMany() {
		for (int i = 0; i < 10; i++) {
			helloSender1.send("hellomsg: " + i);
		}

	}
}