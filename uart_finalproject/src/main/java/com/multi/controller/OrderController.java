package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

	String dir = "order/";
	
	@RequestMapping("")
	public String orderdetail(Model model) {
		model.addAttribute("center", dir+"orderdetail");
		return "main";
	}
}