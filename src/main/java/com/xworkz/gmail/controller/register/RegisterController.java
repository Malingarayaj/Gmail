package com.xworkz.gmail.controller.register;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.gmail.dto.register.RegisterDTO;
import com.xworkz.gmail.service.register.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {
	@Autowired
	private RegisterService service;

	public RegisterController() {
		System.out.println("Object created for:\t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "reg.do", method = RequestMethod.POST)
	public ModelAndView saveToService(RegisterDTO dto) {
		System.out.println("Entering saveToService method in controller");
		System.out.println("Binding data from jsp to Controller");
		try {
			System.out.println(dto);
			RegisterDTO dtoFromService=service.saveToDAO(dto);
			System.out.println(dtoFromService);
			if (dtoFromService != null) {
				return new ModelAndView("registersuccess.jsp", "msg","Thank you for registering:" + dtoFromService.getCname());
			}
		} catch (Exception e) {
			System.err.println("Could not save to service because:" + e.getMessage());
		}

		return new ModelAndView("register.jsp", "emsg", "Please enter valid credentials and fill all fields");
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}
}
