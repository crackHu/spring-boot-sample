package com.senior.sample.manager.rabbitmq.service.impl;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.sample.manager.constant.MQConstant;
import com.senior.sample.manager.exception.RabbitMQException;
import com.senior.sample.manager.modal.DLXMessage;
import com.senior.sample.manager.rabbitmq.service.MessageQueueService;
import com.senior.sample.util.JSONUtils;

/**
 * @desc 消息队列服务接口实现
 * @author Created by Hugo on 2017年12月7日
 */
@Service
public class MessageQueueServiceImpl implements MessageQueueService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void send(String queueName, String msg) throws RabbitMQException {
		rabbitTemplate.convertAndSend(MQConstant.DEFAULT_EXCHANGE, queueName, msg);
	}

	@Override
	public void send(String queueName, String msg, long delays) throws RabbitMQException {
		DLXMessage dlxMessage = new DLXMessage(queueName, msg, delays);
		MessagePostProcessor processor = new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				message.getMessageProperties().setExpiration(delays + "");
				return message;
			}
		};
		dlxMessage.setExchange(MQConstant.DEFAULT_EXCHANGE);
		String message = null;
		try {
			message = JSONUtils.obj2json(dlxMessage);
		} catch (Exception e) {
			throw new RabbitMQException(e);
		}
		rabbitTemplate.convertAndSend(MQConstant.DEFAULT_EXCHANGE, MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME, message,
				processor);
	}
}