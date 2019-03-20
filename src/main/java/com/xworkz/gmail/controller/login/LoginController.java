package com.xworkz.gmail.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.gmail.dto.login.LoginDTO;
import com.xworkz.gmail.service.login.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private LoginService service;

	public LoginController() {
		System.out.println("created:" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView saveToService(LoginDTO dtotoservice) {
		ModelAndView modelview = new ModelAndView();
		try {

			LoginDTO dtoFromDb = service.loginToValidate(dtotoservice);
			if (dtoFromDb != null) {
				System.out.println("Matching object found for" + dtoFromDb.getUserName());
				modelview.addObject("UserName", "Welcome to Gmail home page " + dtoFromDb.getUserName());
				modelview.setViewName("/success.jsp");
				return modelview;
			}
		} catch (Exception e) {

			System.err.println("Exception has stopped us from operation" + e.getMessage());
		}
		modelview.addObject("InvalidMessage", "Invalid username or password");
		modelview.setViewName("login.jsp");
		return modelview;
	}
}
