package com.senior.sample.manager.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.senior.sample.manager.constant.MQConstant;

/**
 * @desc 队列配置
 * @author Created by Hugo on 2017年12月7日
 */
@Configuration
public class QueueConfiguration {
	
    private static Logger logger = LoggerFactory.getLogger(QueueConfiguration.class); 

	// 信道配置
	@Bean
	public DirectExchange defaultExchange() {
		return new DirectExchange(MQConstant.DEFAULT_EXCHANGE, true, false);
	}

	@Bean
	public Queue repeatTradeQueue() {
		Queue queue = new Queue(MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME, true, false, false);
		return queue;
	}

	@Bean
	public Binding drepeatTradeBinding() {
		return BindingBuilder.bind(repeatTradeQueue()).to(defaultExchange())
				.with(MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME);
	}

	@Bean
	public Queue deadLetterQueue() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", MQConstant.DEFAULT_EXCHANGE);
		arguments.put("x-dead-letter-routing-key", MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME);
		Queue queue = new Queue(MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME, true, false, false, arguments);
		logger.info("arguments: {}", queue.getArguments());
		return queue;
	}

	@Bean
	public Binding deadLetterBinding() {
		return BindingBuilder.bind(deadLetterQueue()).to(defaultExchange())
				.with(MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME);
	}

	/********************* hello 队列 测试 *****************/
	@Bean
	public Queue queue() {
		Queue queue = new Queue(MQConstant.HELLO_QUEUE_NAME, true);
		return queue;
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(defaultExchange()).with(MQConstant.HELLO_QUEUE_NAME);
	}

}
