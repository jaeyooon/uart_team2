package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EventblDTO;
import com.multi.dto.ItemDTO;
import com.multi.service.CustomerService;
import com.multi.service.EventblService;
import com.multi.service.ItemService;
import com.multi.service.ItemoptionService;


@Controller
@RequestMapping
public class OrderPageItemController {
	
	@Autowired
	ItemService item_service;
	
	@Autowired
	ItemoptionService itemoption_service;
	
	@Autowired
	CustomerService cust_service;
	
	@Autowired
	EventblService event_service;
	
	String dir = "order/";
	
	@RequestMapping("/orderpageitem")
	public String orderpageitem(Model model, String custid, int itemid, int itemcnt1, int itemcnt2, int itemcnt3) {
		ItemDTO item = null;
		CustomerDTO cust=null;
		EventblDTO event = null;
		boolean result = false;
		
		try {
			item = item_service.get(itemid);
			cust = cust_service.get(custid);
			event = event_service.getcustevent(custid);
			if(event != null) { // 이벤트 참여한 경우
				if(event.getSort() == 1) { // 50% 할인쿠폰 적용한적 없는 경우
					result = true;  // 쿠폰적용가능
				} else {
					result = false;
				}
			} 
			else {		// 이벤트 참여하지 않은 경우
				result = false;		// 적용할 수 있는 쿠폰 없으므로
			}
			
			model.addAttribute("result", result);
			model.addAttribute("itemdetail", item);
			model.addAttribute("itemcnt1", itemcnt1);
			model.addAttribute("itemcnt2", itemcnt2);
			model.addAttribute("itemcnt3", itemcnt3);
			model.addAttribute("cust", cust);
			model.addAttribute("center", dir+"orderpageitem");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
}
