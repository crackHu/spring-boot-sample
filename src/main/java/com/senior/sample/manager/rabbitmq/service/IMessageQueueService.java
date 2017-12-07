package com.senior.sample.manager.rabbitmq.service;

/**
 * @desc 消息队列服务接口
 * @author Created by Hugo on 2017年12月7日
 */
public interface IMessageQueueService {

	/**
	 * 发送消息到队列
	 * @param queue 队列名称
	 * @param message 消息内容
	 */
	public void send(String queueName, String message);

}