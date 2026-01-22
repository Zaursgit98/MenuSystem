package com.zaurdadasov.service;

import com.zaurdadasov.event.RequestAddToMenu;

public interface IMenuService {

	public void addToMenuDrink(RequestAddToMenu addToMenu);
	
	
	public void addToMenuFood(RequestAddToMenu addToMenu);
	
	
}
