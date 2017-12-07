package com.senior.sample.manager.rabbitmq.processor;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.senior.sample.manager.constant.MQConstant;

@Component
@RabbitListener(queues = MQConstant.HELLO_QUEUE_NAME)
public class HelloProcessor {

	@RabbitHandler
	public void process(String content) {
		System.out.println("接受消息:" + content);
	}
}