package com.senior.sample.manager.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senior.sample.manager.constant.MQConstant;
import com.senior.sample.manager.rabbitmq.sender.CallBackSender;
import com.senior.sample.manager.rabbitmq.sender.FanoutSender;
import com.senior.sample.manager.rabbitmq.sender.HelloSender1;
import com.senior.sample.manager.rabbitmq.sender.HelloSender2;
import com.senior.sample.manager.rabbitmq.sender.TopicSender;
import com.senior.sample.manager.rabbitmq.sender.UserSender;
import com.senior.sample.manager.rabbitmq.service.MessageQueueService;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

	@Autowired
	private HelloSender1 helloSender1;
	@Autowired
	private HelloSender2 helloSender2;
	@Autowired
	private UserSender userSender;
	@Autowired
	private TopicSender topicSender;
	@Autowired
	private FanoutSender fanoutSender;
	@Autowired
	private CallBackSender callBackSender;
	@Autowired
	private MessageQueueService messageQueueService;

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

	/**
	 * 多生产者-多消费者
	 */
	@PostMapping("/manyToMany")
	public void manyToMany() {
		for (int i = 0; i < 10; i++) {
			helloSender1.send("hellomsg:" + i);
			helloSender2.send("hellomsg:" + i);
		}
	}

	/**
	 * 实体类传输测试
	 */
	@PostMapping("/userTest")
	public void userTest() {
		userSender.send();
	}

	/**
	 * topic exchange类型rabbitmq测试
	 */
	@PostMapping("/topicTest")
	public void topicTest() {
		topicSender.send();
	}

	/**
	 * fanout exchange类型rabbitmq测试
	 */
	@PostMapping("/fanoutTest")
	public void fanoutTest() {
		fanoutSender.send();
	}

	/**
	 * callback
	 */
	@PostMapping("/callback")
	public void callbak() {
		callBackSender.send();
	}

	@PostMapping("/demo")
	public void demo() throws Exception {
		messageQueueService.send(MQConstant.HELLO_QUEUE_NAME, "测试发送消息");
	}

	@PostMapping("/delay")
	public void delay() throws Exception {
		messageQueueService.send(MQConstant.HELLO_QUEUE_NAME, "测试延迟发送消息: " + System.currentTimeMillis(), 60000);
	}
}