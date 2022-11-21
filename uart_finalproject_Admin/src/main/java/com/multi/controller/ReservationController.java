package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.OrderdetailDTO;
import com.multi.service.OrderdetailService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	OrderdetailService service;
	
	String dir = "reservation/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<OrderdetailDTO> list = null;
		
		try {
			list=service.get();
			model.addAttribute("list",list);
			model.addAttribute("center",dir+"get");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	//리스트를 담아야 한다.
	

}






