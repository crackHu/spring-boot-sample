package com.senior.sample.manager.modal;

import java.io.Serializable;

/**
 * @desc rabbit 死信消息载体
 * @author Created by Hugo on 2017年12月7日
 */
public class DLXMessage implements Serializable {

	private static final long serialVersionUID = 9956432152000L;

	private String exchange;

	private String queueName;

	private String content;

	private long delays;

	public DLXMessage() {
		super();
	}

	public DLXMessage(String queueName, String content, long delays) {
		super();
		this.queueName = queueName;
		this.content = content;
		this.delays = delays;
	}

	public DLXMessage(String exchange, String queueName, String content, long delays) {
		super();
		this.exchange = exchange;
		this.queueName = queueName;
		this.content = content;
		this.delays = delays;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getDelays() {
		return delays;
	}

	public void setDelays(long delays) {
		this.delays = delays;
	}

	@Override
	public String toString() {
		return "DLXMessage [exchange=" + exchange + ", queueName=" + queueName + ", content=" + content + ", delays="
				+ delays + "]";
	}
}