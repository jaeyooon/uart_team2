package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.WishDTO;
import com.multi.dto.CustomerDTO;
import com.multi.dto.ItemDTO;
import com.multi.service.WishService;
import com.multi.service.CustomerService;
import com.multi.service.ItemService;


@Controller
public class WishController {

	@Autowired
	CustomerService cust_service;
	
	@Autowired
	ItemService item_service;
	
	@Autowired
	WishService wish_service;
	
	
	
	@RequestMapping("/wishlist")
	public String wishlist(Model model, String id) {
		List<WishDTO> list = null;
		try {
			list = wish_service.wishall(id);
			model.addAttribute("mywishlist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "wishlist");
		return "main";
	}
	
	@RequestMapping("/deletewish")
	public String deletewish(Model model, int id, String custid) {
		try {
			wish_service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:wishlist?id="+custid;
	}
	
	
}









