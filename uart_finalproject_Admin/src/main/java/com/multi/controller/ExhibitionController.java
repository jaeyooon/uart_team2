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
	ItemoptionService option_service;
	
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<ItemDTO> list= null;
		try {
			list=service.get();
			model.addAttribute("list", list);
			model.addAttribute("center",dir+"get");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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






