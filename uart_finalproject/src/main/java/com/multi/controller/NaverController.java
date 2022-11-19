package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class NaverController {

	String dir = "cust/";

	@Autowired
	CustomerService cust_service;
	
	@RequestMapping("/callback")
	public String callback(Model model) {
		return "/cust/navercallback";
	}
	
	@RequestMapping("/register")
	public String naverRegister(Model model, String custid) {
		System.out.println(custid);
		model.addAttribute("center", dir+"SNSregister");
		return "main";
	}


}