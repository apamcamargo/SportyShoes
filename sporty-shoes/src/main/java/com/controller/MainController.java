package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.repository.UserRepository;
import com.service.OrdersService;
import com.service.ProductService;

@Controller
public class MainController {

	@Autowired
	ProductService productService;

	@Autowired
	OrdersService ordersService;
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping({"/" , "/home"})
	public String home() {
		return "index";
	}
}
