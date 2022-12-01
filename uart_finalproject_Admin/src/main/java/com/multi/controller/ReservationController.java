package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.OrderlistDTO;
import com.multi.mapper.OrderlistMapper;
import com.multi.service.OrderlistService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	OrderlistService service;
	
	@Autowired
	OrderlistMapper mapper;
	
	String dir = "reservation/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<OrderlistDTO> list = null;
		
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
	
	@RequestMapping("/searchimpl")
	public String searchimpl(Model model, String txt) {
		
		List<OrderlistDTO> list=null;
		try {
			list=mapper.searchitem(txt);
			model.addAttribute("list", list);
			model.addAttribute("center", dir+"search_order");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	
	}
	

} 



