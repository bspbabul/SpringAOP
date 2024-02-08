package com.javatechie.os.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.os.entity.Order;
import com.javatechie.os.repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
    private OrderRepository orderRepository;
	
	public List<Order> getAlldata() {
		return orderRepository.findAll();
	}


	public List<Order> getByCategory(String category) {
		return orderRepository.findByCategory(category);
	}
}
