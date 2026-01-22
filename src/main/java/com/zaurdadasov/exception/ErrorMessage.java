package com.zaurdadasov.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage <T>{

	private MessageType messageType;

	private T ofStatic;

	public String prepareMessage() {
		StringBuilder builder = new StringBuilder();
		builder.append(messageType.getMessage());
		if (ofStatic != null) {
			builder.append(" " + ofStatic);
		}
		return builder.toString();

	}
}
