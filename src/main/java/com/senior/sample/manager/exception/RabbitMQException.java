package com.senior.sample.manager.exception;

/**
 * @desc Manager - RabbitMQ 异常
 * @author Created by Hugo on 2017年12月7日
 */
public class RabbitMQException extends ManagerException {

	private static final long serialVersionUID = -6997485114279238671L;

	public RabbitMQException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RabbitMQException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RabbitMQException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RabbitMQException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RabbitMQException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
