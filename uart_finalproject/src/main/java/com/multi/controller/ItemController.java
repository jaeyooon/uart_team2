package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.dto.ReviewDTO;
import com.multi.mapper.ItemMapper;
import com.multi.service.ItemService;
import com.multi.service.ReviewService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService item_service;

	@Autowired
	ItemMapper item_mapper;

	@Autowired
	ReviewService re_service;
	
	String dir = "item/";
	
	@RequestMapping("/medialist")
	public String medialist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(1);
			model.addAttribute("itemlist1", list);
			model.addAttribute("center", dir+"medialist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/explist")
	public String explist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(2);
			model.addAttribute("itemlist2", list);
			model.addAttribute("center", dir+"explist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/privatelist")
	public String privatelist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(3);
			model.addAttribute("itemlist3", list);
			model.addAttribute("center", dir+"privatelist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/speciallist")
	public String speciallist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(4);
			model.addAttribute("itemlist4", list);
			model.addAttribute("center", dir+"speciallist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/artinfolist")
	public String artinfolist(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.select_cate(5);
			model.addAttribute("itemlist5", list);
			model.addAttribute("center", dir+"artinfolist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	
	@RequestMapping("/end_m")
	public String end_m(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_mapper.end_fast(1);
			model.addAttribute("itemlist1", list);
			model.addAttribute("center", dir+"medialist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/end_e")
	public String end_e(Model model) {
		List<ItemDTO> list = null;
		try {		
			list = item_mapper.end_fast(2);
			model.addAttribute("itemlist2", list);
			model.addAttribute("center", dir+"explist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/end_p")
	public String end_p(Model model) {
		List<ItemDTO> list = null;
		try {		
			list = item_mapper.end_fast(3);
			model.addAttribute("itemlist3", list);
			model.addAttribute("center", dir+"privatelist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/end_s")
	public String end_s(Model model) {
		List<ItemDTO> list = null;
		try {		
			list = item_mapper.end_fast(4);
			model.addAttribute("itemlist4", list);
			model.addAttribute("center", dir+"speciallist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/end_a")
	public String end_a(Model model) {
		List<ItemDTO> list = null;
		try {		
			list = item_mapper.end_fast(5);
			model.addAttribute("itemlist5", list);
			model.addAttribute("center", dir+"artinfolist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	
	@RequestMapping("/start_m")
	public String start_m(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_mapper.start_fast(1);
			model.addAttribute("itemlist1", list);
			model.addAttribute("center", dir+"medialist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/start_e")
	public String start_e(Model model) {
		List<ItemDTO> list = null;
		try {			
			list = item_mapper.start_fast(2);
			model.addAttribute("itemlist2", list);
			model.addAttribute("center", dir+"explist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/start_p")
	public String start_p(Model model) {
		List<ItemDTO> list = null;
		try {			
			list = item_mapper.start_fast(3);
			model.addAttribute("itemlist3", list);
			model.addAttribute("center", dir+"privatelist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/start_s")
	public String start_s(Model model) {
		List<ItemDTO> list = null;
		try {			
			list = item_mapper.start_fast(4);
			model.addAttribute("itemlist4", list);
			model.addAttribute("center", dir+"speciallist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/start_a")
	public String start_a(Model model) {
		List<ItemDTO> list = null;
		try {			
			list = item_mapper.start_fast(5);
			model.addAttribute("itemlist5", list);
			model.addAttribute("center", dir+"artinfolist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
	
		
	@RequestMapping("/itemdetail")
	public String itemdetail(Model model, int itemid) {
		ItemDTO item = null;
		List<ReviewDTO> review = null;
		try {
			item = item_service.get(itemid);
			review = re_service.get_itemreview(itemid);
			model.addAttribute("itemdetail", item);
			model.addAttribute("review", review);
			model.addAttribute("center", dir+"itemdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
	}
}
