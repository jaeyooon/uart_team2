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
		
	@RequestMapping("/itemoption")
	public String itemdetail(Model model, int itemid) {
		ItemDTO item1 = null;
		ItemDTO item2=null;
		ItemDTO item3=null;
		
		try {
			item1 = item_service.get(itemid);
			item2=item_service.get2(itemid);
			item3=item_service.get3(itemid);
			
			model.addAttribute("itemdetail1", item1);
			model.addAttribute("itemdetail2", item2);
			model.addAttribute("itemdetail3", item3);
			
			model.addAttribute("center", "itemoption");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
}
