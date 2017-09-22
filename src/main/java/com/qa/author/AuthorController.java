package com.qa.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.victoria.demos.dataservice.IAuthorService;
import com.victoria.demos.model.Author;
import com.victoria.demos.model.Product;


@Controller
public class AuthorController {

	@Autowired
	private IAuthorService authorServ;
	
	@RequestMapping(value="/list-authors", method = RequestMethod.GET)
	public String getAuthors(ModelMap model) {
		model.addAttribute("authors", authorServ.getAllAuthors());
		System.out.println("getting to controller");
		return "list-authors";
	}
	
	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public String showAuthorPage(ModelMap model) {
		model.addAttribute("author", new Author());
		return "author";
	}
	

}
