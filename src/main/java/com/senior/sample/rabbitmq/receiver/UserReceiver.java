package com.senior.sample.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.senior.sample.User;

@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {

	@RabbitHandler
	public void process(User user) {
		System.out.println("user receive : " + user.getUsername() + "/" + user.getPassword());
	}

}