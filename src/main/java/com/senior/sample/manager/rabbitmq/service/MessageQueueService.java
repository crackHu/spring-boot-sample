package com.senior.sample.manager.rabbitmq.service;

import com.senior.sample.manager.exception.RabbitMQException;

/**
 * @desc 消息队列服务接口
 * @author Created by Hugo on 2017年12月7日
 */
public interface MessageQueueService {

	/**
	 * 发送消息到队列
	 * @param queue 队列名称
	 * @param message 消息内容
	 * @throws RabbitMQException
	 */
	public void send(String queueName, String message) throws RabbitMQException;

	/**
	 * 延迟发送消息到队列
	 * @param queue 队列名称
	 * @param message 消息内容
	 * @param delays 延迟时间 单位毫秒
	 * @throws RabbitMQException
	 */
	public void send(String queueName, String message, long delays) throws RabbitMQException;

}