package com.senior.sample.manager.rabbitmq.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.sample.manager.constant.MQConstant;
import com.senior.sample.manager.rabbitmq.service.IMessageQueueService;

/**
 * @desc 消息队列服务接口实现
 * @author Created by Hugo on 2017年12月7日
 */
@Service
public class MessageQueueServiceImpl implements IMessageQueueService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void send(String queueName, String msg) {
		rabbitTemplate.convertAndSend(MQConstant.DEFAULT_EXCHANGE, queueName, msg);
	}
}