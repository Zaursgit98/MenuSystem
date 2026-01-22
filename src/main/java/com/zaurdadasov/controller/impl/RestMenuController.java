package com.zaurdadasov.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaurdadasov.controller.IRestMenuController;
import com.zaurdadasov.event.RequestAddToMenu;
import com.zaurdadasov.service.IMenuService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/menu")
public class RestMenuController implements IRestMenuController {

	@Autowired
	private IMenuService menuService;

	@PostMapping("/adddrinks")
	@Override
	public void addToMenuDrinks(@RequestBody @Valid RequestAddToMenu addToMenu) {
		menuService.addToMenuDrink(addToMenu);

	}

	@PostMapping("/addfoods")
	@Override
	public void addToMenuFood( @RequestBody @Valid RequestAddToMenu addToMenu) {
		menuService.addToMenuFood(addToMenu);
	}

}