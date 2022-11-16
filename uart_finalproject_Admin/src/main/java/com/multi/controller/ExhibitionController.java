package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exhibition")
public class ExhibitionController {

	String dir = "exhibition/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		model.addAttribute("center",dir+"get");
		return "main";
	}
	

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center",dir+"register");
		return "main";
	}
	

	
	
	
}






