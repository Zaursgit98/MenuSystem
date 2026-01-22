package com.zaurdadasov.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaurdadasov.controller.IRestOrderController;
import com.zaurdadasov.dto.DtoDrinks;
import com.zaurdadasov.dto.DtoFoods;
import com.zaurdadasov.dto.DtoOrder;
import com.zaurdadasov.model.Orders;
import com.zaurdadasov.service.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/menu")
public class RestOrderControllerImpl implements IRestOrderController {

	@Autowired
	private IOrderService orderService;

	@GetMapping("/allFoods")
	@Override
	public List<DtoFoods> getAllFoods() {
		return orderService.getAllFoods();
	}

	@GetMapping("/allDrinks")
	@Override
	public List<DtoDrinks> getAllDrinks() {

		return orderService.getAllDrinks();
	}

	@PostMapping("/orderFood")
	@Override
	public Orders orderFood(@RequestBody @Valid DtoOrder order) {

		return orderService.orderFood(order);
	}

	@DeleteMapping("/cancelOrder/{id}")
	@Override
	public String cancelOrder(@PathVariable Long id,@RequestBody DtoOrder order) {

		 String cancelOrder = orderService.cancelOrder(id,order);
		 
		 return ResponseEntity.ok(cancelOrder).getBody();
	}

	@PutMapping("/updateOrder/{id}")
	@Override
	public Orders updateOrder(@PathVariable Long id, @RequestBody DtoOrder dtoOrder) {
	     return       orderService.updateOrder(id, dtoOrder);
	}

}

















