package com.multi.controller;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EmanageDTO;
import com.multi.dto.EventblDTO;
import com.multi.dto.ItemDTO;
import com.multi.dto.OrderdetailDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.frame.Util;
import com.multi.mapper.AJAXMapper;
import com.multi.ncp.OCR;
import com.multi.service.CustomerService;
import com.multi.service.EmanageService;
import com.multi.service.EventblService;
import com.multi.service.ItemService;
import com.multi.service.OrderdetailService;
import com.multi.service.OrderlistService;

@RestController
public class AJAXController {

	@Autowired
	CustomerService cust_service;
	
	@Autowired
	EmanageService emanage_service;
	
	@Autowired
	EventblService event_service;
	
	@Autowired
	OrderlistService olist_service;
	
	@Autowired
	OrderdetailService odetail_service;
	
	@Autowired
	ItemService item_service;
	
	@Autowired
	AJAXMapper ajax_mapper;
	
	
	@Value("${custdir}")
	String custdir;
	
	@Autowired
	OCR ocr;
	
	@RequestMapping("/purchaseimpl")
	public int purchaseimpl(int itemid, String custid, int ordercnt, int totalprice, String phone2, String item_itemname, String cust_name, Date candate) {
		int neworderlistid = 0;
		OrderlistDTO neworder = null;
		ItemDTO item = null;
		try {
			neworder = new OrderlistDTO(0, itemid, custid, null, ordercnt, totalprice, "신용카드", phone2, candate, item_itemname, cust_name);
			olist_service.register(neworder);
			int r = neworder.getOrderlistid();
			neworderlistid = r;
			
			item = item_service.get(itemid);
			odetail_service.register(new OrderdetailDTO(0, r, itemid, item.getItemplace(), item.getEstart(), item.getEfin(), item.getItemimg(), item_itemname, ordercnt, null, candate, custid));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return neworderlistid;
	}
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result ="";
		CustomerDTO cust = null;
		try {
			cust = cust_service.get(cid);
			if(cust != null) {
				result = "f";
			} else {
				result = "t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	@RequestMapping("/ocrimpl")
	public Object ocrimpl(Model model, EventblDTO event) {
		Object obj = null;
		
		String imgname = event.getUploadimg().getOriginalFilename();
		System.out.println(imgname);
		
			Util.saveFile(event.getUploadimg(), custdir);
			obj = ocr.ocrresult(imgname);
		
		
		return obj;
	}
	
	@RequestMapping("/ocrTnumberCheck")
	public Object ocrTnumberCheck(Model model, String tnumber, String custid) {
		System.out.println(tnumber);
		boolean result = false;
		EmanageDTO emanage = null;
		try {
			emanage = emanage_service.get(tnumber);
			System.out.println("업로드된 수험표 정보 : " + emanage);
			
			if(emanage != null) { // 중복 사용된 경우
				result = false;
			}else {
				emanage_service.register(new EmanageDTO(tnumber, null));
				event_service.register(new EventblDTO(null, custid, null, null, null, null, null, null,null));
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	@RequestMapping("/autosearch")
	public Object autosearch() {
		List<ItemDTO> list = null;
		
		try {
			list=ajax_mapper.getname();  //전시이름 select
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONArray ja=new JSONArray(); //배열선언

		for(ItemDTO i:list) { //배열에 이름 담기
			ja.add(i.getItemname());
		}
		
		return ja;
	}

	
}
