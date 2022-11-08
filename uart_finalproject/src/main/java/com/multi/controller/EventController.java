package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EventblDTO;
import com.multi.service.CustomerService;
import com.multi.service.EventblService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventblService event_service;
	
	@Autowired
	CustomerService cust_service;
	
	String dir = "event/";
	
	@RequestMapping("/get")
	public String event(Model model) {
		EventblDTO event = null;
		try {
			event = event_service.get(50);
			model.addAttribute("event", event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir+"eventlist");
		return "main";
	}
	
	
	@RequestMapping("/getinfo1")
	public String getinfo1(Model model) {
		model.addAttribute("center", dir+"eventinfo1");
		return "main";
	}
	
	@RequestMapping("/getinfo2")
	public String getinfo2(Model model) {
		model.addAttribute("center", dir+"eventinfo2");
		return "main";
	}
	
	@RequestMapping("/ocr")
	public String ocr(Model model, String custid, int id) {
		CustomerDTO cust = null;
		EventblDTO event = null;
		try {
			cust = cust_service.get(custid);
			event = event_service.get(id);
			model.addAttribute("cust", cust);
			model.addAttribute("event", event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir+"ocr");
		return "main";
	}
	
	
	
	
}