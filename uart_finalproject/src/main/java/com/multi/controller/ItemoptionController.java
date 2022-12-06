package com.multi.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;


@Controller
@RequestMapping
public class ItemoptionController {
	
	@Autowired
	ItemService item_service;
	
	String dir = "item/";
		
	@RequestMapping("/itemoption")
	public String itemdetail(Model model, int itemid) {
		ItemDTO item = null;
	
		
		try {
			item = item_service.get(itemid);
		
			
			model.addAttribute("itemdetail", item);
		
			
			model.addAttribute("center", dir+"itemoption");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
}
