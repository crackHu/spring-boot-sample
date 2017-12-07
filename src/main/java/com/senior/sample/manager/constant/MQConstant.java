package com.senior.sample.manager.constant;

/**
 * @desc Rabbit 消息队列相关常量
 * @author Created by Hugo on 2017年12月7日
 */
public final class MQConstant {

	private MQConstant() {
	}

	// exchange name
	public static final String DEFAULT_EXCHANGE = "PEOPLESMEDIC";

	// DLX QUEUE
	public static final String DEFAULT_DEAD_LETTER_QUEUE_NAME = "peoplesmedic.dead.letter.queue";

	// DLX repeat QUEUE 死信转发队列
	public static final String DEFAULT_REPEAT_TRADE_QUEUE_NAME = "peoplesmedic.repeat.trade.queue";

	// Hello 测试消息队列名称
	public static final String HELLO_QUEUE_NAME = "HELLO";

}