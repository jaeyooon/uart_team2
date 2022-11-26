package com.multi.controller;

import java.awt.ItemSelectable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.mapper.ItemMapper;
import com.multi.service.ItemService;

@Controller
public class MainController {
	
	@Autowired
	ItemService item_service;
	
	@Autowired
	ItemMapper item_mapper;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/aboutus")
	public String aboutus(Model model) {
		model.addAttribute("center", "aboutus");
		return "main";
	}
	
	@RequestMapping("/recommend")
	public String recommend(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.gethighgrade();
			model.addAttribute("recommendlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "recommenditem");
		return "main";
	}
	
	@RequestMapping("/event")
	public String event(Model model) {
		model.addAttribute("center", "eventlist");
		return "main";
	}
	
	@RequestMapping("/faq")
	public String faq(Model model) {
		model.addAttribute("center", "faq");
		return "main";
	}
	
	@RequestMapping("/searchimpl")
	public String searchimpl(Model model, String txt) {
		
		List<ItemDTO> list=null;
		try {
			list=item_mapper.searchitem(txt);
			
				if(list.size()==0) {
					model.addAttribute("center", "searchfail");
				}else {
					model.addAttribute("list", list);
					model.addAttribute("center", "search");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	
	}
	
	@RequestMapping("/chatbot")
	public String chatbot(Model model) {
		model.addAttribute("center", "chatbot");
		return "main";
	}
	
}