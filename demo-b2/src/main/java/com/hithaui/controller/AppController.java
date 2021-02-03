package com.hithaui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hithaui.entities.Account;

@Controller
public class AppController {

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("account", new Account());
		return mav;
	}
	
	@PostMapping("/users")
	public ModelAndView login(@ModelAttribute("account") Account account) {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("acc", account);
		return modelAndView;
	}
}
