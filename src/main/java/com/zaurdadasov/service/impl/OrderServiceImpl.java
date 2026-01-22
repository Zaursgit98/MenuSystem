package com.zaurdadasov.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaurdadasov.dto.DtoDrinks;
import com.zaurdadasov.dto.DtoFoods;
import com.zaurdadasov.dto.DtoOrder;
import com.zaurdadasov.exception.BaseException;
import com.zaurdadasov.exception.ErrorMessage;
import com.zaurdadasov.exception.MessageType;
import com.zaurdadasov.model.ChatMessage;
import com.zaurdadasov.model.Drinks;
import com.zaurdadasov.model.Foods;
import com.zaurdadasov.model.Orders;
import com.zaurdadasov.repository.DrinkRepository;
import com.zaurdadasov.repository.FoodRepository;
import com.zaurdadasov.repository.OrderRepositoryTab1;
import com.zaurdadasov.service.IOrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private ChatMessageServiceImpl messageService;

	@Autowired
	private OrderRepositoryTab1 orderRepositoryTab1;

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private DrinkRepository drinkRepository;

	@Autowired

	@Override
	public List<DtoFoods> getAllFoods() {
		List<Foods> allFoods = foodRepository.findAll();
		List<DtoFoods> listDtoFoods = new ArrayList<>();

		for (Foods foods : allFoods) {
			DtoFoods dtoFoods = new DtoFoods();
			dtoFoods.setFoodName(foods.getFoodName());
			dtoFoods.setFoodPrice(foods.getFoodPrice());
			listDtoFoods.add(dtoFoods);
		}

		return listDtoFoods;
	}

	@Override
	public List<DtoDrinks> getAllDrinks() {
		List<Drinks> alldDrinks = drinkRepository.findAll();
		
		List<DtoDrinks> listdDtoDrinks = new ArrayList<>();

		for (Drinks drinks : alldDrinks) {
			DtoDrinks dtoDrinks = new DtoDrinks();
			dtoDrinks.setDrinkName(drinks.getDrinkName());
			dtoDrinks.setDrinkPrice(drinks.getDrinkPrice());
			listdDtoDrinks.add(dtoDrinks);
		}
		return listdDtoDrinks;
	}

	@Transactional
	@Override
	public Orders orderFood(DtoOrder dtoOrder) {

		List<String> orderList = foodRepository.findAll().stream()
				.filter(food -> dtoOrder.getOrders().stream().anyMatch(req -> food.getFoodName().equalsIgnoreCase(req)))
				.map(Foods::getFoodName).collect(Collectors.toList());
		
		if (orderList.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.ORDER_IS_NOT_EXSIST,dtoOrder.getOrders()));
		}

		Orders orders = new Orders();
		orders.setOrders(orderList);

		Orders save = orderRepositoryTab1.save(orders);

		ChatMessage chatMessage = new ChatMessage<>();
		chatMessage.setCreateAtTime(LocalDateTime.now());
		chatMessage.setMessage(orders);
		messageService.handleIncomingMessage(chatMessage);

		return save;
	}

	
	@Override
	public String cancelOrder(Long id, DtoOrder dtoOrder) {
		Orders optOrder = orderRepositoryTab1.findById(id)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.ORDER_IS_NOT_EXSIST, id.toString())));
		List<String> dbOrders = optOrder.getOrders();
		List<String> canOrders = dtoOrder.getOrders();

		dbOrders.removeIf(dbOrder -> canOrders.stream().anyMatch(canorder -> canorder.equalsIgnoreCase(dbOrder)));
		orderRepositoryTab1.save(optOrder);
		return "sifarisiniz legv olundu";
	}

	@Override
	public Orders updateOrder(Long id, DtoOrder dtoOrder) {
	
			Optional<Orders> optOrder = orderRepositoryTab1.findById(id);
			
			if (optOrder.isEmpty()) {
				throw new BaseException(new ErrorMessage(MessageType.ORDER_IS_NOT_EXSIST,id.toString()));
			}
			
			optOrder.get().getOrders().addAll(dtoOrder.getOrders());
//			
//			List<String> dbOrders = optOrder.get().getOrders();
//			List<String> uptOrders = dtoOrder.getOrders();
//
//			
//			for (String uptOrder : uptOrders) {
//				dbOrders.add(uptOrder);
//			}

			Orders save = orderRepositoryTab1.save(optOrder.get());
			return save;

		} 

	}









