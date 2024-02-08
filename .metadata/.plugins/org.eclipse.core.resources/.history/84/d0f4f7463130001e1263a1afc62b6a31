package com.javatechie.os.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.os.entity.Order;
import com.javatechie.os.services.OrderServices;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	public OrderServices orderServices;

	@GetMapping
	public List<Order> getOrders() {
		return orderServices.getAlldata();
	}

	@GetMapping("/{category}")
	public List<Order> getOrdersByCategory(@PathVariable String category) {
		return orderServices.getByCategory(category);
	}

}
