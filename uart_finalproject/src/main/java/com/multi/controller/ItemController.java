package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.dto.ReviewDTO;
import com.multi.service.ItemService;
import com.multi.service.ReviewService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService item_service;


	@Autowired
	ReviewService re_service;
	
	String dir = "item/";
	
	@RequestMapping("/medialist")
	public String medialist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(1);
			model.addAttribute("itemlist1", list);
			model.addAttribute("center", dir+"medialist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/explist")
	public String explist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(2);
			model.addAttribute("itemlist2", list);
			model.addAttribute("center", dir+"explist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/privatelist")
	public String privatelist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(3);
			model.addAttribute("itemlist3", list);
			model.addAttribute("center", dir+"privatelist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/speciallist")
	public String speciallist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(4);
			model.addAttribute("itemlist4", list);
			model.addAttribute("center", dir+"speciallist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
		
	@RequestMapping("/itemdetail")
	public String itemdetail(Model model, int itemid) {
		ItemDTO item = null;
		List<ReviewDTO> review = null;
		try {
			item = item_service.get(itemid);
			review = re_service.get_itemreview(itemid);
			model.addAttribute("itemdetail", item);
			model.addAttribute("review", review);
			model.addAttribute("center", dir+"itemdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
}
