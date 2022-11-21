package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	String dir = "reservation/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		model.addAttribute("center",dir+"get");
		return "main";
	}
	
	//리스트를 담아야 한다.
	

}






