package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.EventblDTO;
import com.multi.dto.OrderdetailDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.service.EventblService;
import com.multi.service.OrderdetailService;
import com.multi.service.OrderlistService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderdetailService odetail_service;
	
	@Autowired
	OrderlistService olist_service;
	
	@Autowired
	EventblService event_service;

	String dir = "order/";
	
	@RequestMapping("/checknew")
	public String checknew(Model model, int id, String custid) {
		System.out.println(custid);
		EventblDTO event = null;
		OrderlistDTO neworder = null;
		
		try {
			event = event_service.getcidevent(custid);
			if(event != null) {
				event_service.deletecoupon(event);
			}
			
			neworder = olist_service.get(id);
			model.addAttribute("neworder", neworder);
			model.addAttribute("center", dir+"checknew");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
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
	
	@RequestMapping("/alldetailinfo")
	public String alldetailinfo(Model model, int orderlistid) {
		OrderlistDTO orderinfo = null;  // 구매내역 페이지 정보 불러오기 위해
		OrderdetailDTO orderdetail = null;  // 예매내역 페이지 정보 불러오기 위해
		try {
			orderinfo = olist_service.get(orderlistid);
			orderdetail = odetail_service.getallinfo(orderlistid);
			model.addAttribute("orderinfo", orderinfo);
			model.addAttribute("orderdetail", orderdetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir+"alldetailinfo");
		return "main";
	}
	
	@RequestMapping("/cancel")
	public String cancel(Model model, String custid, int orderlistid) {
		try {
			System.out.println(custid);
			olist_service.remove(orderlistid);
			odetail_service.remove(orderlistid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
}
