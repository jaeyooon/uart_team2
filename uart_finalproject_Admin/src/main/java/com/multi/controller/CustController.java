package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustController {


	@Autowired
	CustomerService service;
	
	String dir = "cust/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<CustomerDTO> list = null;
		Integer withdrawal = null;
		
		try {
			list = service.get();
			
			model.addAttribute("list",list);
			model.addAttribute("center",dir+"get");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, String custid) {
		CustomerDTO cust = null;
		try {
			cust = service.get(custid);
			model.addAttribute("c",cust);
			model.addAttribute("center",dir+"detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}	
}






