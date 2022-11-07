package com.multi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/notice")
public class NoticeController {

	String dir = "notice/";
	
	
	
	@RequestMapping("/notice4")
	public String notice4(Model model) {
		model.addAttribute("center", dir+"notice4");
		
		return "main";
	}
	
	@RequestMapping("/notice3")
	public String notice3(Model model) {
		model.addAttribute("center", dir+"notice3");
		
		return "main";
	}
	
	@RequestMapping("/notice2")
	public String notice2(Model model) {
		model.addAttribute("center", dir+"notice2");
		
		return "main";
	}
	
	@RequestMapping("/notice1")
	public String notice1(Model model) {
		model.addAttribute("center", dir+"notice1");
		
		return "main";
	}
	
	
}
	
	
	
	
	

