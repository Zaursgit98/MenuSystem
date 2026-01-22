package com.zaurdadasov.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestPageableRequest {

	private int pageSize;
	
	private int pageNumber;
	
	private boolean asc;
	
	private String columnName;
}
