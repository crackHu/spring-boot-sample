package com.senior.sample.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senior.sample.rabbitmq.sender.CallBackSender;
import com.senior.sample.rabbitmq.sender.FanoutSender;
import com.senior.sample.rabbitmq.sender.HelloSender1;
import com.senior.sample.rabbitmq.sender.HelloSender2;
import com.senior.sample.rabbitmq.sender.TopicSender;
import com.senior.sample.rabbitmq.sender.UserSender;

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
	
	@PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }
}