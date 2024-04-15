package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Category;
import com.model.Orders;
import com.model.Product;
import com.repository.CategoryRepository;
import com.repository.UserRepository;
import com.service.CategoryService;
import com.service.OrdersService;
import com.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	OrdersService ordersService;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String adminHome() {

		return "admin";
	}

	@GetMapping(value = "/manageProducts")
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

	@GetMapping(value = "/productsManager")
	public String productManagement(Model model, Product product) {

		String name = "Store Product";

		List<Product> listOfProduct = productService.findAllProducts();
		List<Object[]> orderdetails = productService.orderDetails();

		model.addAttribute("products", listOfProduct);
		model.addAttribute("buttonValue", name);
		model.addAttribute("product", product);
		model.addAttribute("orderdetails", orderdetails);
		model.addAttribute("categories", categoryService.getAllCategories());

		System.out.println(listOfProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProductDetails(Model model, Product product, Category category, HttpServletRequest req) {
		String b1 = req.getParameter("b1");
		String result = "";
		String name = "";
		if (b1.equals("Store Product")) {
			result = productService.storeProduct(product);
		} else {
			result = productService.updateProduct(product);
		}
		name = "Store Product";
		product.setPid(product.getPid());
		product.setPname(product.getPname());
		product.setPrice(product.getPrice());
		product.setCategory(category);
		model.addAttribute("product", product);
		List<Product> listOfProduct = productService.findAllProducts();
		List<Object[]> orderdetails = productService.orderDetails();
		model.addAttribute("orderdetails", orderdetails);
		model.addAttribute("products", listOfProduct);
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("msg", result);
		model.addAttribute("buttonValue", name);
		return "addProduct";
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String deleteProductById(Model model, Product product, HttpServletRequest req) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		System.out.println("pid is " + pid);
		String name = "Store Product";
		String result = productService.deleteProduct(pid);
		List<Product> listOfProduct = productService.findAllProducts();
		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		model.addAttribute("msg", result);
		model.addAttribute("buttonValue", name);
		List<Object[]> orderdetails = productService.orderDetails();
		model.addAttribute("orderdetails", orderdetails);
		return "addProduct";
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
	public String searchProductById(Model model, HttpServletRequest req) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		String name = "Update Product";
		Product product = productService.searchProductById(pid);
		List<Product> listOfProduct = productService.findAllProducts();
		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("buttonValue", name);
		List<Object[]> orderdetails = productService.orderDetails();
		model.addAttribute("orderdetails", orderdetails);
		// model.addAttribute("msg", result);

		return "addProduct";
	}

	@GetMapping(value = "/orders")
	public String orders(Model model, Product product) {

		String name = "Store Product";

		List<Product> listOfProduct = productService.findAllProducts();
		List<Object[]> orderdetails = productService.orderDetails();

		model.addAttribute("orderdetails", orderdetails);

		System.out.println(listOfProduct);
		return "orders";
	}

	@RequestMapping(value = "/orderPlace", method = RequestMethod.GET)
	public String placeOrder(Model model, HttpServletRequest req, Orders order, Product product) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		order.setPid(pid);
		String name = "Store Product";
		String result = ordersService.placeOrder(order);
		List<Product> listOfProduct = productService.findAllProducts();
		List<Object[]> orderdetails = productService.orderDetails();

		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		model.addAttribute("msg", result);
		model.addAttribute("buttonValue", name);
		// model.addAttribute("msg", result);

		model.addAttribute("orderdetails", orderdetails);
		return "addProduct";
	}

	@GetMapping("/categories")
	public String getCat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "categories";
	}

	@GetMapping("/categories/add")
	public String getCatAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}

	@PostMapping("/categories/add")
	public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("/categories/delete/{id}")
	public String deleteCat(Category category) {

		categoryService.removeCategoryById(category.getId());

		return "redirect:/admin/categories";
	}

	@GetMapping("/categories/update/{id}")
	public String updateCat(Category categoryV, Model model) {

		Optional<Category> category = categoryService.getCatById(categoryV.getId());

		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		} else {
			return "404";
		}

	}
}
