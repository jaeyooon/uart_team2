package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.OrderlistDTO;
import com.multi.mapper.OrderlistMapper;
import com.multi.service.OrderlistService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	OrderlistService service;
	
	@Autowired
	OrderlistMapper mapper;
	
	String dir = "reservation/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<OrderlistDTO> list = null;
		
		try {
			list=service.get();
			model.addAttribute("list",list);
			model.addAttribute("center",dir+"get");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	//리스트를 담아야 한다.
	
	@RequestMapping("/searchimpl")
	public String searchimpl(Model model, String txt) {
		
		List<OrderlistDTO> list=null;
		try {
			list=mapper.searchitem(txt);
			model.addAttribute("list", list);
			model.addAttribute("txt", txt);   //search한 후 결과들을 다시 최신순, 빠른순으로 정렬하기 위해서 txt를 담아주는 것
			model.addAttribute("center", dir+"search_order");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	
	}
	
	@RequestMapping("/latest_r")
	public String latest_r(Model model) { //예매날짜 최신순 정렬
		
		List<OrderlistDTO> list=null;
		try {
			list= mapper.latest_r();
			model.addAttribute("list", list);
			model.addAttribute("center", dir+"get");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/early_r")
	public String early_r(Model model) { //예매날짜 빠른순 정렬
		
		List<OrderlistDTO> list=null;
		try {
			list= mapper.early_r();
			model.addAttribute("list", list);
			model.addAttribute("center", dir+"get");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/latest2_r")
	public String latest2_r(Model model, String txt) {
		
		List<OrderlistDTO> list=null;
		try {
			list=mapper.latest2_r(txt);  //searchimpl에서 model에 담은 txt를 받을 수 있도록 함수 설정
			model.addAttribute("list", list);
			model.addAttribute("txt", txt);
			model.addAttribute("center", dir+"search_order");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	

	@RequestMapping("/early2_r")
	public String early2_r(Model model, String txt) {
		
		List<OrderlistDTO> list=null;
		try {
			list=mapper.early2_r(txt);
			model.addAttribute("list", list);
			model.addAttribute("txt", txt);
			model.addAttribute("center", dir+"search_order");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
} 



