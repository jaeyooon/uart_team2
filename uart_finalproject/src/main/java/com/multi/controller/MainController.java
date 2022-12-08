package com.multi.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.dto.OrderdetailDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.mapper.ItemMapper;
import com.multi.service.CustomerService;
import com.multi.service.ItemService;
import com.multi.service.OrderdetailService;
import com.multi.service.OrderlistService;

@Controller
public class MainController {
	
	@Autowired
	ItemService item_service;
	
	@Autowired
	CustomerService cust_service;
	
	@Autowired
	ItemMapper item_mapper;
	
	@Autowired
	OrderlistService olist_service;
	
	@Autowired
	OrderdetailService odetail_service;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/thankyou")
	public String thankyou(Model model, String id, int itemid, int ordercnt, int totalprice, String phone2) {
		int neworderlistid = 0;
		
		String item_itemname = null;
		String cust_name = null;
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);	// candate(취소가능일)는 오늘 날짜 + 1달이므로
		Date candate = new Date(cal.getTimeInMillis());
		
		OrderlistDTO neworder = null;
		ItemDTO item = null;
		try {
			item_itemname = item_service.get(itemid).getItemname();
			cust_name = cust_service.get(id).getCname();
			
			neworder = new OrderlistDTO(0, itemid, id, null, ordercnt, totalprice, "신용카드", phone2, candate, item_itemname, cust_name);
			olist_service.register(neworder);
			int r = neworder.getOrderlistid();
			neworderlistid = r;
			
			item = item_service.get(itemid);
			odetail_service.register(new OrderdetailDTO(0, r, itemid, item.getItemplace(), item.getEstart(), item.getEfin(), item.getItemimg(), item_itemname, ordercnt, null, candate, id));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("custname", cust_name);
		model.addAttribute("neworderlistid", neworderlistid);
		model.addAttribute("center", "thankyou");
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