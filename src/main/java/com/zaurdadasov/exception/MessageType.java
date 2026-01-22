package com.zaurdadasov.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_CORRECT_CONTENT("1000","Mezmun duzgun deyil"),
	ORDER_IS_NOT_EXSIST("1001","Daxil etdiyiniz sifaris movcud deyil");
	
	String code;
	String message;
	
	private MessageType(String code,String message) {
		this.message=message;
		this.code=code;
	}
}
