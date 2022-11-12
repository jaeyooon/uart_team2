package com.multi.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.dto.ItemoptionDTO;
import com.multi.dto.CustomerDTO;

import com.multi.service.ItemService;
import com.multi.service.ItemoptionService;
import com.multi.service.CustomerService;


@Controller
@RequestMapping
public class OrderPageItemController {
	
	@Autowired
	ItemService item_service;
	
	@Autowired
	ItemoptionService itemoption_service;
	
	@Autowired
	CustomerService cust_service;
	
	@RequestMapping("/orderpageitem")
	public String orderpageitem(Model model, String custid, int itemid, int itemcnt1, int itemcnt2, int itemcnt3) {
		ItemDTO item = null;
		CustomerDTO cust=null;
		try {
			item = item_service.get(itemid);
			cust = cust_service.get(custid);
			model.addAttribute("itemdetail", item);
			model.addAttribute("itemcnt1", itemcnt1);
			model.addAttribute("itemcnt2", itemcnt2);
			model.addAttribute("itemcnt3", itemcnt3);
			model.addAttribute("cust", cust);
			model.addAttribute("center", "orderpageitem");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
}
