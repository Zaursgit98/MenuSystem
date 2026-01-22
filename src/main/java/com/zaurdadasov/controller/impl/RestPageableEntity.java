package com.zaurdadasov.controller.impl;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestPageableEntity<T> {

	private List<T>content;
	
	private long pageNumber;
	
	private long pageSize;
	
	private long totalElements;
}
