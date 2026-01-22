package com.zaurdadasov.controller;

import java.util.List;

import com.zaurdadasov.dto.DtoDrinks;
import com.zaurdadasov.dto.DtoFoods;
import com.zaurdadasov.dto.DtoOrder;
import com.zaurdadasov.model.Orders;

public interface IRestOrderController {
	public List<DtoFoods> getAllFoods();

	public List<DtoDrinks> getAllDrinks();

	public Orders orderFood(DtoOrder order);
	
	public String cancelOrder(Long id,DtoOrder order);
	
	public Orders updateOrder(Long id,DtoOrder dtoOrder);

}
