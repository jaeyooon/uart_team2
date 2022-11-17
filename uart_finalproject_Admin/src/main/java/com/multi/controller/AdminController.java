package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	String dir = "admin/";
	
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
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, AdminDTO adm) {
		try {
			service.register(adm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model) {
    model.addAttribute("center",dir+"detail");
		return "main";
	}
	
	
	
	
}






