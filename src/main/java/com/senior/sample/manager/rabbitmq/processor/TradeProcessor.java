package com.senior.sample.manager.rabbitmq.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.senior.sample.manager.constant.MQConstant;
import com.senior.sample.manager.modal.DLXMessage;
import com.senior.sample.manager.rabbitmq.service.MessageQueueService;
import com.senior.sample.util.JSONUtils;

@Component
@RabbitListener(queues = MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME)
public class TradeProcessor {

	private static Logger logger = LoggerFactory.getLogger(TradeProcessor.class);

	@Autowired
	private MessageQueueService messageQueueService;

	@RabbitHandler
	public void process(String content) {
		try {
			System.out.println("TradeProcessor process: " + content + " at: " + System.currentTimeMillis());
			DLXMessage message = JSONUtils.json2pojo(content, DLXMessage.class);
			messageQueueService.send(message.getQueueName(), message.getContent());
		} catch (Exception e) {
			logger.error("Oops, TradeProcessor process occur error", e);
		}
	}
}