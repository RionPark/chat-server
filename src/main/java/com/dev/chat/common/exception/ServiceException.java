package com.dev.chat.common.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ServiceException(String msg) {
		super(msg);
	}
}