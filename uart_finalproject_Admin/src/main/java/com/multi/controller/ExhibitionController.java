package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.dto.ItemoptionDTO;
import com.multi.service.ItemService;
import com.multi.service.ItemoptionService;

@Controller
@RequestMapping("/exhibition")
public class ExhibitionController {

	String dir = "exhibition/";
	
	@Autowired
	ItemService service;
	
	@Autowired
	ItemoptionService option_service;
	
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<ItemDTO> list= null;
		try {
			list=service.get();
			model.addAttribute("list", list);
			model.addAttribute("center",dir+"get");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center",dir+"register");
		return "main";
	}
	

	@RequestMapping("/register_price")
	public String register_price(Model model) {
		model.addAttribute("center",dir+"price");
		return "main";
	}
	
	@RequestMapping("/registerimpl_price")
	public String registerimpl_price(Model model, ItemoptionDTO option) throws Exception {
		option_service.register(option);
		
		return "redirect:get";
	}
	
	
	
}






