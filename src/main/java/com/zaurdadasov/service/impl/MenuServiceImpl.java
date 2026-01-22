package com.zaurdadasov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaurdadasov.event.RequestAddToMenu;
import com.zaurdadasov.model.Drinks;
import com.zaurdadasov.model.Foods;
import com.zaurdadasov.repository.DrinkRepository;
import com.zaurdadasov.repository.FoodRepository;
import com.zaurdadasov.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private DrinkRepository drinkRepository;

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public void addToMenuDrink(RequestAddToMenu addToMenu) {
		Drinks drinks = new Drinks();
		drinks.setDrinkName(addToMenu.getName());
		drinks.setDrinkPrice(addToMenu.getPrice());
		drinkRepository.save(drinks);

	}

	@Override
	public void addToMenuFood(RequestAddToMenu addToMenu) {
		Foods foods = new Foods();
		foods.setFoodName(addToMenu.getName());
		foods.setFoodPrice(addToMenu.getPrice());
		foodRepository.save(foods);}
	
	
}
