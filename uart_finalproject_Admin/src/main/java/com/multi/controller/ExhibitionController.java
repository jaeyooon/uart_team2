package com.multi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.dto.ItemoptionDTO;
import com.multi.frame.Util;
import com.multi.mapper.ItemMapper;
import com.multi.service.ItemService;
import com.multi.service.ItemoptionService;



@Controller
@RequestMapping("/exhibition")
public class ExhibitionController {

	String dir = "exhibition/";
	
	@Value("${item_admindir}")
	String item_admindir;
	
	@Value("${item_custdir}")
	String item_custdir;
	
	@Autowired
	ItemService service;
	
	@Autowired
	ItemMapper item_mapper;
	
	@Autowired
	ItemoptionService option_service;
	
	
	@RequestMapping("/get")
	public String get(Model model, String page) {
		List<ItemDTO> list= null;
		int totalrows = 0;
		int totalpages = 0;
		int cpage = 0;		// 현재 페이지
		int cblock = 0; 	// 시작페이지와 마지막 페이지 포함하는 하나의 블럭
		int startpage = 0;
		int endpage = 0;
		int selectstart = 0;	// mapper의 selectpage 인수로 들어감
		int prev = 0;		// 현재 1페이지에 있는데 이전페이지로 가려고 할때를 위해 필요=>prev 없을경우 0페이지 존재, 1페이지에서도 이전으로 가는 꺽쇠 생김

		
		//System.out.println(page);
		
		try {
			if(page == null || page.isEmpty()) {
				cpage = 1;
				//System.out.println("*" + cpage);
			} else {
				cpage = Integer.parseInt(page);
				//System.out.println(cpage);
			}
			
			if(cpage == 1) {    
				prev = 1;
				//System.out.println("prev: " + prev);
			}
			
			cblock = cpage % 5 == 0? cpage / 5 : (cpage / 5) + 1;  // 한 블럭 당 다섯 페이지로 구성
			startpage = (cblock - 1) * 5 + 1;  // 첫번째 블럭에서는 1 그 다음 6 , 11, 16, 21, 26, 31 
			endpage = startpage + 5 - 1;   // 첫 번째 블럭에서는 5 그 다음 10, 15, 20, 25, 30, 35
			System.out.println("S: " + startpage);
			System.out.println("E: " + endpage);
			
			totalrows = item_mapper.getTotal(); 
			totalpages = totalrows % 6 == 0 ? totalrows / 6 : (totalrows / 6) + 1;
			System.out.println(totalpages);  // 총 페이지 수 7 
			System.out.println(totalrows);   // 총 데이터 수 41
			if(totalpages == 0) {
				totalpages = 1;
			}
			if(endpage > totalpages) {	// 마지막 페이지가 총 페이지 수를 넘어가면 끝 페이지를 마지막 페이지 숫자로 지정
				endpage = totalpages;
			}
			
			// -------- 페이징 처리(한 페이지당 6개씩 상품목록 나오도록 select)
			selectstart = (cpage - 1) * 6;
			list = item_mapper.selectpage(selectstart);
			
			model.addAttribute("list", list);
			model.addAttribute("center", dir+"get");
			model.addAttribute("totalpages", totalpages);
			model.addAttribute("totalrows", totalrows);
			model.addAttribute("startpage", startpage);
			model.addAttribute("endpage", endpage);
			model.addAttribute("cpage", cpage);
			model.addAttribute("prev", prev);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center",dir+"register");
		return "main";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, ItemDTO item) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  //String to Date 
		Date estart= format.parse(item.getF_estart());
		Date efin= format.parse(item.getF_efin());
		item.setEstart(estart);
		item.setEfin(efin);
		
		String itemimg=item.getImg().getOriginalFilename(); //파일이름 빼내기
		item.setItemimg(itemimg);
		//System.out.println(admindir);
		
		try {
			Util.saveFile(item.getImg(), item_admindir, item_custdir); //파일에 먼저 저장
			service.register(item);
		} catch (Exception e) {
	    	e.printStackTrace();
		}
		return "redirect:register_price";
	}
	

	@RequestMapping("/register_price")
	public String register_price(Model model) {
		model.addAttribute("center",dir+"price");
		return "main";
	}
	
	@RequestMapping("/registerimpl_price")
	public String registerimpl_price(Model model, ItemoptionDTO option) throws Exception {
		option_service.register(option);
		
		return "redirect:get";
	}
	
	@RequestMapping("/itemdetail")
	public String detail(Model model, Integer itemid ) {
		ItemDTO item= null;
		
		try {
			item=service.get(itemid);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //Date to String
			String f_estart= format.format(item.getEstart());
			String f_efin=format.format(item.getEfin());
			item.setF_estart(f_estart);
			item.setF_efin(f_efin);
			model.addAttribute("itemdetail", item);
			model.addAttribute("center",dir+"itemdetail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/updateimpl")
	public String updateimpl(Model model, ItemDTO item) throws Exception{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  //String to Date 
		Date estart= format.parse(item.getF_estart());
		Date efin= format.parse(item.getF_efin());
		item.setEstart(estart);
		item.setEfin(efin);
		try {
			service.modify(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:get";
		
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, Integer itemid) {
		try {
			service.remove(itemid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:get";
	}
	
	
	
}






