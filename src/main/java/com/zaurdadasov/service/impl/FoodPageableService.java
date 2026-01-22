package com.zaurdadasov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zaurdadasov.dto.DtoFoods;
import com.zaurdadasov.model.Foods;
import com.zaurdadasov.repository.FoodPageableRepository;



@Service
public class FoodPageableService {

	@Autowired
	private FoodPageableRepository repository;
	
	
	
	public Page<Foods>  getAllFoodPages(Pageable pageable) {
		                   
		
		 return   repository.findAll(pageable);
		
	}
	public List<DtoFoods>dtoFoodList(List<Foods>foodlList){
	       List<DtoFoods>dtoFoodList=new ArrayList<>();
	      
	       for(Foods foods:foodlList) {
	    	   DtoFoods dtoFoods=new DtoFoods();
	    	    BeanUtils.copyProperties(foods, dtoFoods);
	    	    
	            dtoFoodList.add(dtoFoods);
	            }
	return dtoFoodList;
	
	
}

}
