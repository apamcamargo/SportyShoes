package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Orders;
import com.model.Product;
import com.service.OrdersService;
import com.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	OrdersService ordersService;

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shop(Model model, Product product) {

		String name = "Store Product";

		List<Product> listOfProduct = productService.findAllProducts();
		List<Object[]> orderdetails = productService.orderDetails();

		model.addAttribute("products", listOfProduct);
		model.addAttribute("buttonValue", name);
		model.addAttribute("product", product);
		model.addAttribute("orderdetails", orderdetails);

		System.out.println(listOfProduct);
		return "shop";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String getProduct(Model model, Product product) {

		String name = "Store Product";

		List<Product> listOfProduct = productService.findAllProducts();
		List<Object[]> orderdetails = productService.orderDetails();

		model.addAttribute("products", listOfProduct);
		model.addAttribute("buttonValue", name);
		model.addAttribute("product", product);
		model.addAttribute("orderdetails", orderdetails);

		System.out.println(listOfProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/orderPlace", method = RequestMethod.GET)
	public String placeOrder(Model model, HttpServletRequest req, Orders order, Product product) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		order.setPid(pid);
		String name = "Store Product";
		String result = ordersService.placeOrder(order);
		List<Product> listOfProduct = productService.findAllProducts();
		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		model.addAttribute("msg", result);
		model.addAttribute("buttonValue", name);
		// model.addAttribute("msg", result);
		List<Object[]> orderdetails = productService.orderDetails();
		model.addAttribute("orderdetails", orderdetails);
		return "shop";
	}
}
