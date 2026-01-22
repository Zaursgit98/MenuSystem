package com.zaurdadasov.exception;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	private List<String> addValue(List<String> list, String value) {
		list.add(value);
		return list;

	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodNotValidException(MethodArgumentNotValidException ex,WebRequest request) {
		Map<String, List<String>> errorMap = new HashMap<>();

		for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
			String field = ((FieldError) objectError).getField();

			if (errorMap.containsKey(field)) {
				errorMap.put(field, addValue(errorMap.get(field), objectError.getDefaultMessage()));

			} else {
				errorMap.put(field, addValue(new ArrayList<>(), objectError.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(errorMap,request));
	}
	
	
	@ExceptionHandler(value = BaseException.class)
	public ResponseEntity<ApiError<String>> exceptionMessage(BaseException ex,WebRequest request) {
		return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));
		
	}
	
 private String getHostName() {
	    try {
		return	Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	 return "";
 }
	
 
	
	private <T> ApiError<T> createApiError(T error,WebRequest request) {
		ApiError apiError = new ApiError<>();
		
		Exception exception=new Exception<>();
		exception.setMessage(error);
		exception.setCreateAtTime(new Date());
		exception.setPath(request.getDescription(false).substring(4));
		exception.setHostName(getHostName());
		
		apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		apiError.setException(exception);

		return apiError;
	}

}







