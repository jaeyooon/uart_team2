package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cust")
public class CustController {

	String dir = "cust/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		model.addAttribute("center",dir+"get");
		return "main";
	}
	@RequestMapping("/detail")
	public String detail(Model model) {
    model.addAttribute("center",dir+"detail");
		return "main";
	}
	
	
}






