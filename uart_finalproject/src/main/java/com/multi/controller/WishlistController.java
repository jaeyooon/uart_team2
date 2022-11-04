package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.WishlistDTO;
import com.multi.dto.CustomerDTO;
import com.multi.dto.ItemDTO;
import com.multi.service.WishlistService;
import com.multi.service.CustomerService;
import com.multi.service.ItemService;


@Controller
public class WishlistController {

	@Autowired
	CustomerService cust_service;
	
	@Autowired
	ItemService item_service;
	
	@Autowired
	WishlistService wishlist_service;
	
	
	
	@RequestMapping("/wishlist")
	public String wishlist(Model model, String id) {
		List<WishlistDTO> list = null;
		try {
			list = wishlist_service.wishlistall(id);
			model.addAttribute("mywishlist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "wishlist");
		return "main";
	}
	
	@RequestMapping("/deletewishlist")
	public String deletewishlist(Model model, int id, String custid) {
		try {
			wishlist_service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:wishlist?id="+custid;
	}
	
	@RequestMapping("/addwishlist")
	public Object addwishlist(WishlistDTO wish) {
		try {
			wishlist_service.register(wish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	
}









