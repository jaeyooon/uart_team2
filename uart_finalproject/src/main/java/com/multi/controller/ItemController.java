package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService item_service;

	String dir = "item/";
	
	@RequestMapping("/medialist")
	public String medialist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(1);
			model.addAttribute("itemlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir+"medialist");
		return "main";
	}
	
	@RequestMapping("/explist")
	public String explist(Model model) {
		model.addAttribute("center", dir+"explist");
		return "main";
	}
	
	@RequestMapping("/privatelist")
	public String privatelist(Model model) {
		model.addAttribute("center", dir+"privatelist");
		return "main";
	}
	
	@RequestMapping("/speciallist")
	public String speciallist(Model model) {
		model.addAttribute("center", dir+"speciallist");
		return "main";
	}
	
	@RequestMapping("/itemdetail")
	public String itemdetail(Model model, int itemid) {
		ItemDTO item = null;
		try {
			item = item_service.get(itemid);
			model.addAttribute("itemdetail", item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir+"itemdetail");
		return "main";
	}
}
