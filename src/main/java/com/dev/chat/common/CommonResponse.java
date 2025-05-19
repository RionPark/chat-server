package com.dev.chat.common;

public class CommonResponse<T> {//E, K, V, T
	private boolean success;
	private T data;
	private String msg;
	
	public static <T> CommonResponse<T> success(T data){
		CommonResponse<T> response = new CommonResponse<T>();
		response.success = true;
		response.data = data;
		return response;
	}
	
	public static <T> CommonResponse<T> error(String msg){
		CommonResponse<T> response = new CommonResponse<T>();
		response.success = false;
		response.msg = msg;
		return response;
	}
	
}
