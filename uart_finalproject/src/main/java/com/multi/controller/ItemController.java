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
	public String artinfolist(Model model, String page) {
		List<ItemDTO> list = null;
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
			
			cblock = cpage % 3 == 0? cpage / 3 : (cpage / 3) + 1;  // 한 블럭 당 세 페이지로 구성
			startpage = (cblock - 1) * 3 + 1;  // 첫번째 블럭에서는 1 그 다음 4 , 7 
			endpage = startpage + 3 - 1;   // 첫 번째 블럭에서는 3 그 다음 6, 9
			
			totalrows = item_mapper.getTotal(); 
			totalpages = totalrows % 6 == 0 ? totalrows / 6 : (totalrows / 6) + 1;
//			System.out.println(totalpages);  // 총 페이지 수 3 
//			System.out.println(totalrows);   // 총 데이터 수 17
			if(totalpages == 0) {
				totalpages = 1;
			}
			if(endpage > totalpages) {	// 마지막 페이지가 총 페이지 수를 넘어가면 끝 페이지를 마지막 페이지 숫자로 지정
				endpage = totalpages;
			}
			
			// -------- 페이징 처리(한 페이지당 6개씩 상품목록 나오도록 select)
			selectstart = (cpage - 1) * 6;
			list = item_mapper.selectpage(selectstart);
			
			model.addAttribute("itemlist5", list);
			model.addAttribute("center", dir+"artinfolist");
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
	public String end_a(Model model, String page) {
		List<ItemDTO> list = null;
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
			
			cblock = cpage % 3 == 0? cpage / 3 : (cpage / 3) + 1;  // 한 블럭 당 세 페이지로 구성
			startpage = (cblock - 1) * 3 + 1;  
			endpage = startpage + 3 - 1;  
			
			totalrows = item_mapper.getTotal(); 
			totalpages = totalrows % 6 == 0 ? totalrows / 6 : (totalrows / 6) + 1;
//			System.out.println(totalpages);  // 총 페이지 수 3 
//			System.out.println(totalrows);   // 총 데이터 수 17
			if(totalpages == 0) {
				totalpages = 1;
			}
			if(endpage > totalpages) {	
				endpage = totalpages;
			}
			
			// -------- 페이징 처리(한 페이지당 6개씩 상품목록 나오도록 select)
			selectstart = (cpage - 1) * 6;
			list = item_mapper.end_fastPaging(selectstart);
			
			model.addAttribute("itemlist5", list);
			model.addAttribute("center", dir+"artinfolistEF");
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
	public String start_a(Model model, String page) {
		List<ItemDTO> list = null;
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
			
			cblock = cpage % 3 == 0? cpage / 3 : (cpage / 3) + 1;  // 한 블럭 당 세 페이지로 구성
			startpage = (cblock - 1) * 3 + 1;  
			endpage = startpage + 3 - 1;  
			
			totalrows = item_mapper.getTotal(); 
			totalpages = totalrows % 6 == 0 ? totalrows / 6 : (totalrows / 6) + 1;
//			System.out.println(totalpages);  // 총 페이지 수 3 
//			System.out.println(totalrows);   // 총 데이터 수 17
			if(totalpages == 0) {
				totalpages = 1;
			}
			if(endpage > totalpages) {	
				endpage = totalpages;
			}
			
			// -------- 페이징 처리(한 페이지당 6개씩 상품목록 나오도록 select)
			selectstart = (cpage - 1) * 6;
			list = item_mapper.start_fastPaging(selectstart);
			
			model.addAttribute("itemlist5", list);
			model.addAttribute("center", dir+"artinfolistSF");
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
