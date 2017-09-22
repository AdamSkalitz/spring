package com.victoria.demos.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.victoria.demos.dataservice.IProductService;
import com.victoria.demos.model.Product;


@Controller
public class ProductController {

	@Autowired
	private IProductService service;
	
	@RequestMapping(value = "/list-products", method = RequestMethod.GET)
	public String showProducts(ModelMap model) {
		model.addAttribute("products", service.getAllProducts());
		//model.addAttribute("name", "An Author");
		return "list-products";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String showProductPage(ModelMap model) {
		model.addAttribute("product", new Product());
		return "product";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(ModelMap model, @Valid Product product, BindingResult result) {

		if (result.hasErrors())
			return "product";

		service.addProduct(product);
		
		model.clear();// to prevent request parameter "user" to be passed
		return "redirect:/list-products";
	}
	
	
	
	@RequestMapping(value = "/delete-product", method = RequestMethod.GET)
	public String deleteProduct(@RequestParam int id) {
		service.deleteProduct(id);

		return "redirect:/list-products";
	}
	
	//update functionality
	
	@RequestMapping(value = "/update-product", method = RequestMethod.GET)
	public String showUpdateProductPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("product", service.getProductByID(id));
		return "product";
	}

	@RequestMapping(value = "/update-product", method = RequestMethod.POST)
	public String updateBook(ModelMap model, @Valid Product product, BindingResult result) {
		if (result.hasErrors())
			return "product";

		//removed hard-coding
		service.updateProduct(product);

		model.clear();// to prevent request parameter "user" to be passed
		return "redirect:/list-products";
	}
	
}