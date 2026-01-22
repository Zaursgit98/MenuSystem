package com.zaurdadasov.controller.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zaurdadasov.dto.DtoFoods;
import com.zaurdadasov.event.RestPageableRequest;
import com.zaurdadasov.util.PagerUtil;

public class RestBaseController {

	public Pageable toPageable(RestPageableRequest request) {
		
	return	PagerUtil.toPageable(request);
	}
	
	public<T> RestPageableEntity<T> toPageableResponce(Page<?>page,List<T>content) {
		return PagerUtil.toPageableResponce(page, content);
		
	}
	
	public<T> RestRootEntity ok(RestPageableEntity<DtoFoods> pageableResponce){
		
		return RestRootEntity.ok(pageableResponce);
	}
	
	
}
