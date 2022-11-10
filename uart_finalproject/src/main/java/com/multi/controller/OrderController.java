package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.OrderdetailDTO;
import com.multi.service.OrderdetailService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderdetailService odetail_service;

	String dir = "order/";
	
	@RequestMapping("/detail")
	public String detail(Model model, String id) {
		List<OrderdetailDTO> list = null;
		try {
			list = odetail_service.getallorderdetail(id);
			model.addAttribute("detaillist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir+"orderdetail");
		return "main";
	}
}
