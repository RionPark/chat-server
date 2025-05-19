package com.dev.chat.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.chat.common.exception.ServiceException;

@ControllerAdvice
@RestController
public class CommonExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CommonResponse<?> handleException(Exception e) {
		return CommonResponse.error("서버에서 오류가 발생하였습니다.");
	}
	
	@ExceptionHandler(ServiceException.class)
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public CommonResponse<?> handleServiceException(ServiceException e){
		return CommonResponse.error(e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CommonResponse<?> handleValiException(MethodArgumentNotValidException e){
		BindingResult br = e.getBindingResult();
		List<ObjectError> errors = br.getAllErrors();
		Map<String,String> errorMap = new LinkedHashMap<>();
		for(ObjectError error : errors) {
			FieldError fe = (FieldError) error;
			String fieldName = fe.getField();
			String msg = error.getDefaultMessage();
			errorMap.put(fieldName, msg);
		}
		return CommonResponse.error(errorMap.toString());
	}
	
}
