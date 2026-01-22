package com.zaurdadasov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaurdadasov.dto.DtoFoods;
import com.zaurdadasov.event.RestPageableRequest;
import com.zaurdadasov.model.Foods;
import com.zaurdadasov.service.impl.FoodPageableService;

@RestController
@RequestMapping("/pageable")
public class FoodPageableController extends RestBaseController {

	@Autowired
	private FoodPageableService service;

	@GetMapping("/foodpages")
	public RestRootEntity getAllFoodPages(RestPageableRequest request) {
		    Page<Foods> page = service.getAllFoodPages(toPageable(request));
		  RestPageableEntity<DtoFoods> pageableResponce = toPageableResponce(page, service.dtoFoodList(page.getContent()));
		    return ok(pageableResponce);
	}

}
