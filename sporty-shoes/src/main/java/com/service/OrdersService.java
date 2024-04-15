package com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Orders;
import com.model.Product;
import com.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	public String placeOrder(Orders orders) {
			// oid auto increment we need only pid as fk 
			orders.setLdt(LocalDateTime.now());
		
		ordersRepository.save(orders);
		return "Order placed successfully for product "+orders.getPid();
	}
	
	public List<Orders> findAllOrders() {
		return ordersRepository.findAll();		// select * from product in SQL
	}	
}
