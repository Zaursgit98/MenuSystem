package com.zaurdadasov.controller.impl;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestRootEntity<T> {
	
	private Integer status;
	
	private T payload;
	
	private String errorMessage;

		public static <T> RestRootEntity ok(T payload) {
		RestRootEntity rootEntity=new RestRootEntity<>();
		rootEntity.setStatus(HttpStatus.OK.value());
		rootEntity.setErrorMessage(null);
		rootEntity.setPayload(payload);
		
		return rootEntity;
	}

}
