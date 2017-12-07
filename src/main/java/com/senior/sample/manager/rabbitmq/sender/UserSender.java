package com.senior.sample.manager.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.senior.sample.User;

@Component
public class UserSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		User user = new User();
		user.setUsername("hzb");
		user.setPassword("123456789");
		System.out.println("user send : " + user.getUsername() + "/" + user.getPassword());
		this.rabbitTemplate.convertAndSend("userQueue", user);
	}
}