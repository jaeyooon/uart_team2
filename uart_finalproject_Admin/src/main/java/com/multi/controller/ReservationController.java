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
	public String get(Model model, String page) {
		List<OrderlistDTO> list = null;
		int totalrows = 0;
		int totalpages = 0;
		int cpage = 0;		// 현재 페이지
		int cblock = 0; 	// 시작페이지와 마지막 페이지 포함하는 하나의 블럭
		int startpage = 0;
		int endpage = 0;
		int selectstart = 0;	// mapper의 selectpage 인수로 들어감
		int prev = 0;		// 현재 1페이지에 있는데 이전페이지로 가려고 할때를 위해 필요
		
		try {
			if(page == null || page.isEmpty()) {
				cpage = 1;
			} else {
				cpage = Integer.parseInt(page);
			}
			
			if(cpage == 1) {    
				prev = 1;
			}
			
			cblock = cpage % 5 == 0? cpage / 5 : (cpage / 5) + 1;  // 한 블럭 당 다섯 페이지로 구성
			startpage = (cblock - 1) * 5 + 1;  
			endpage = startpage + 5 - 1;   
			
			totalrows = mapper.getTotal(); 
			totalpages = totalrows % 10 == 0 ? totalrows / 10 : (totalrows / 10) + 1;
//			System.out.println(totalpages);  // 총 페이지 수  
//			System.out.println(totalrows);   // 총 데이터 수 
			if(totalpages == 0) {
				totalpages = 1;
			}
			if(endpage > totalpages) {	// 마지막 페이지가 총 페이지 수를 넘어가면 끝 페이지를 마지막 페이지 숫자로 지정
				endpage = totalpages;
			}
			
			// -------- 페이징 처리(한 페이지당 10개씩 상품목록 나오도록 select)
			selectstart = (cpage - 1) * 10;
			list = mapper.selectpage(selectstart);
			
			model.addAttribute("list",list);
			model.addAttribute("center",dir+"get");
			model.addAttribute("totalpages", totalpages);
			model.addAttribute("startpage", startpage);
			model.addAttribute("endpage", endpage);
			model.addAttribute("cpage", cpage);
			model.addAttribute("prev", prev);
			
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
	public String latest_r(Model model, String page) { //예매날짜 최신순 정렬
		
		List<OrderlistDTO> list=null;
		int totalrows = 0;
		int totalpages = 0;
		int cpage = 0;		
		int cblock = 0; 	
		int startpage = 0;
		int endpage = 0;
		int selectstart = 0;	// mapper의 selectpage 인수로 들어감
		int prev = 0;		// 현재 1페이지에 있는데 이전페이지로 가려고 할때를 위해 필요
		
		try {
			if(page == null || page.isEmpty()) {
				cpage = 1;
			} else {
				cpage = Integer.parseInt(page);
			}
			
			if(cpage == 1) {    
				prev = 1;
			}
			
			cblock = cpage % 5 == 0? cpage / 5 : (cpage / 5) + 1;  // 한 블럭 당 다섯 페이지로 구성
			startpage = (cblock - 1) * 5 + 1;  
			endpage = startpage + 5 - 1;   
			
			totalrows = mapper.getTotal(); 
			totalpages = totalrows % 10 == 0 ? totalrows / 10 : (totalrows / 10) + 1;
//			System.out.println(totalpages);  // 총 페이지 수  
//			System.out.println(totalrows);   // 총 데이터 수 
			if(totalpages == 0) {
				totalpages = 1;
			}
			if(endpage > totalpages) {	// 마지막 페이지가 총 페이지 수를 넘어가면 끝 페이지를 마지막 페이지 숫자로 지정
				endpage = totalpages;
			}
			
			// -------- 페이징 처리(한 페이지당 10개씩 상품목록 나오도록 select)
			selectstart = (cpage - 1) * 10;
			list = mapper.latest_r(selectstart);
			
			model.addAttribute("list",list);
			model.addAttribute("center",dir+"getLatest");
			model.addAttribute("totalpages", totalpages);
			model.addAttribute("startpage", startpage);
			model.addAttribute("endpage", endpage);
			model.addAttribute("cpage", cpage);
			model.addAttribute("prev", prev);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/early_r")
	public String early_r(Model model, String page) { //예매날짜 빠른순 정렬
		
		List<OrderlistDTO> list=null;
		int totalrows = 0;
		int totalpages = 0;
		int cpage = 0;		
		int cblock = 0; 	
		int startpage = 0;
		int endpage = 0;
		int selectstart = 0;	// mapper의 selectpage 인수로 들어감
		int prev = 0;		// 현재 1페이지에 있는데 이전페이지로 가려고 할때를 위해 필요
		
		try {
			if(page == null || page.isEmpty()) {
				cpage = 1;
			} else {
				cpage = Integer.parseInt(page);
			}
			
			if(cpage == 1) {    
				prev = 1;
			}
			
			cblock = cpage % 5 == 0? cpage / 5 : (cpage / 5) + 1;  // 한 블럭 당 다섯 페이지로 구성
			startpage = (cblock - 1) * 5 + 1;  
			endpage = startpage + 5 - 1;   
			
			totalrows = mapper.getTotal(); 
			totalpages = totalrows % 10 == 0 ? totalrows / 10 : (totalrows / 10) + 1;
//			System.out.println(totalpages);  // 총 페이지 수  
//			System.out.println(totalrows);   // 총 데이터 수 
			if(totalpages == 0) {
				totalpages = 1;
			}
			if(endpage > totalpages) {	// 마지막 페이지가 총 페이지 수를 넘어가면 끝 페이지를 마지막 페이지 숫자로 지정
				endpage = totalpages;
			}
			
			// -------- 페이징 처리(한 페이지당 10개씩 상품목록 나오도록 select)
			selectstart = (cpage - 1) * 10;
			list= mapper.early_r(selectstart);
			
			model.addAttribute("list",list);
			model.addAttribute("center",dir+"getEarly");
			model.addAttribute("totalpages", totalpages);
			model.addAttribute("startpage", startpage);
			model.addAttribute("endpage", endpage);
			model.addAttribute("cpage", cpage);
			model.addAttribute("prev", prev);
			
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



