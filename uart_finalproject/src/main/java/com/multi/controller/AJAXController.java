package com.multi.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EmanageDTO;
import com.multi.dto.EventblDTO;
import com.multi.dto.ItemDTO;
import com.multi.dto.OrderdetailDTO;
import com.multi.dto.OrderlistDTO;
import com.multi.dto.ReviewDTO;
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
import com.multi.service.ReviewService;
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
	
	@Autowired
	ReviewService review_service;
	
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
			neworder = new OrderlistDTO(0, itemid, custid, null, ordercnt, totalprice, "????????????", phone2, candate, item_itemname, cust_name);
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
			if(event != null) { // ????????? ????????? ??????
				if(event.getSort() == 1) { // 50% ???????????? ???????????? ?????? ??????
					result = true;  // ??????????????????
				} else {
					result = false;
				}
			} 
			else {		// ????????? ???????????? ?????? ??????
				result = false;		// ????????? ??? ?????? ?????? ????????????
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
			System.out.println("???????????? ????????? ?????? : " + emanage);
			
			if(emanage != null) { // ?????? ????????? ??????
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
			list=ajax_mapper.getname();  //???????????? select
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONArray ja=new JSONArray(); //????????????

		for(ItemDTO i:list) { //????????? ?????? ??????
			ja.add(i.getItemname());
		}
		
		return ja;
	}

	
	/* ??????????????? ?????? */
	/**
	 * 0: ?????? ??????
	 * 1: ?????? ??????
	 * 2: ????????? ????????? ??????
	 * 5: ????????? ??????
	 * 
	 */
	@RequestMapping("/wishlist/add")
	@ResponseBody
	public String addWishPOST(WishlistDTO wish,HttpServletRequest request) {
		// ????????? ??????
				HttpSession session = request.getSession();
				CustomerDTO cust = (CustomerDTO)session.getAttribute("logincust");
				if(cust == null) {
					return "5";
				}
		
		// ?????? ??????
		
		int result = wishlist_service.addWish(wish);
		
		return result + "";
	}	
	
	@RequestMapping("/naverlogin")
	public Object naverlogin(Model model, String cname, String email, String gender, HttpSession session) {
		boolean result = false;
		
		System.out.println("###?????? : "+cname);
		System.out.println("###????????? : "+ email);
		System.out.println("###?????? : "+gender);
		
		String [] nemail = email.split("@"); // id ?????? ???????????? ?????? @???????????? ????????? ?????????
		String nid = nemail[0];
		//System.out.println(nid);
		
		if(gender.equals("F")) {
			gender = new String("???");
		} else {
			gender = new String("???");
		}
		//System.out.println(gender);
		
		CustomerDTO cust = null;
		try {
			cust = cust_service.get(nid);
			if(cust == null) {
				cust_service.register(new CustomerDTO(nid, null, cname, null, gender, email, null, null, null));
			
				CustomerDTO newnavercust = cust_service.get(nid);
				System.out.println(newnavercust);
				
				session.setAttribute("logincust", newnavercust);
				result = true;
			} else {
				if(cust.getWithdrawal() == 1)	// ???????????? ?????? ????????? ?????? ????????? ???????????????
				session.setAttribute("logincust", cust);
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(result);
		return result;
	}
	
	@RequestMapping("/checkorderdetail")
	public Object checkorderdetail(Model model,  Integer itemid, String custid) {
		System.out.println(itemid);
		System.out.println(custid);
		boolean result = false;
		
		List<OrderdetailDTO> list1 = null;
		try {
			list1 = odetail_service.checkorderdetail(itemid); // itemid??? ???????????? ??????
			System.out.println(list1);
			if(list1 != null) {
				for(OrderdetailDTO list : list1) {
					if(list.getCust_custid().equals(custid)) { // itemid??? ???????????? ???????????? ?????? ?????? custid??? ??????????????? ????????? ??????
						result = true;
						break;		// result??? true??? ?????? for?????? ????????????
					} else {
						result = false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(result);
		return result;
	}
	
	@RequestMapping("/registerreview")
	public Object registerreview(Model model,  Integer itemid, String custid, String reviewcontent, Double reviewgrade) {
		boolean result = false;
		
		List<ReviewDTO> lastreview = null;
		try {
			lastreview = review_service.getitemreview(itemid);
			System.out.println(lastreview);
			if(lastreview == null || lastreview.isEmpty()) {  // ??????????????? ?????? ????????? ??????????????? ?????? ??????
				ReviewDTO review = new ReviewDTO(0,itemid,custid,reviewcontent,reviewgrade, null);
				review_service.register(review);
				
				result = true;
				System.out.println("OK");
			} 
			else {
				for(ReviewDTO review : lastreview) {
					if(review.getCustid().equals(custid)) {  // ??????????????? ?????? ????????? ????????? ?????? ?????? ??????
						result = false;
					} else {								// itemid??? ?????? ?????? ??? ??????????????? ????????? ????????? ?????? ??????
						ReviewDTO review2 = new ReviewDTO(0,itemid,custid,reviewcontent,reviewgrade, null);
						review_service.register(review2);
						
						result = true;
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//System.out.println(result);
		return result;
	}
}
