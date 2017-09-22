//package com.victoria.demos.login;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//@Controller
//@SessionAttributes("user")
//public class LoginController_old {
//
////	@RequestMapping(value="/login")
////	//@ResponseBody this will return content direct to the page
////	public String sayHello() {
////		//return "Hello from Spring MVC's Login Controller";
////		return "login";
////	}
//	
//	@Autowired
//	LoginService loginService;
//	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String showLoginPage() {
//		return "login";
//	}
//	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String handleLoginRequest(@RequestParam String user, @RequestParam String password, ModelMap model) {
//		 if (!loginService.validateUser(user, password)) {
//			 model.put("errorMessage", "Your credentials are invalid. Please try again.");
//			 return "login";
//	}
//	model.put("user", user);
//	return "welcome";
//	}
//	
//
//
//}
