package com.multi.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EmanageDTO;
import com.multi.dto.EventblDTO;
import com.multi.dto.ItemDTO;
import com.multi.dto.OrderdetailDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.WishlistDTO;
import com.multi.frame.Util;
import com.multi.mapper.AJAXMapper;
import com.multi.ncp.OCR;
import com.multi.service.CustomerService;
import com.multi.service.EmanageService;
import com.multi.service.EventblService;
import com.multi.service.ItemService;
import com.multi.service.OrderdetailService;
import com.multi.service.OrderlistService;
import com.multi.service.WishlistService;

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
	
	@Autowired
	WishlistService wishlist_service;
	
	
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
	
	@RequestMapping("/checkcoupon")
	public Object checkcoupon(String custid) {
		boolean result = false;
		EventblDTO event = null;
		
		try {
			event = event_service.getcustevent(custid);
			if(event != null) {
				if(event.getSort() == 1) { // 50% 할인쿠폰 적용한적 없는 경우
					result = true;  // 쿠폰적용가능
				} else {
					result = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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
				event_service.register(new EventblDTO(null, custid, null, null, null, null, null, null, null, null));
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
	
	/*@RequestMapping("/wishlist/add")
	public Object addwishlist(WishlistDTO wish) {
		try {
			wishlist_service.register(wish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}*/
	
	/* 장바구니 추가 */
	/**
	 * 0: 등록 실패
	 * 1: 등록 성공
	 * 2: 등록된 데이터 존재
	 * 5: 로그인 필요
	 * 
	 */
	@RequestMapping("/wishlist/add")
	@ResponseBody
	public String addCartPOST(WishlistDTO cart,HttpServletRequest request) {
		// 로그인 체크
				HttpSession session = request.getSession();
				CustomerDTO mvo = (CustomerDTO)session.getAttribute("logincust");
				if(mvo == null) {
					return "5";
				}
		
		// 카트 등록
		
		int result = wishlist_service.addCart(cart);
		
		return result + "";
	}	
}
