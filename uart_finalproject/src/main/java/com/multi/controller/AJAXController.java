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
	
	@RequestMapping("/naverlogin")
	public Object naverlogin(Model model, String cname, String email, String gender, HttpSession session) {
		boolean result = false;
		
		System.out.println("###이름 : "+cname);
		System.out.println("###이메일 : "+ email);
		System.out.println("###성별 : "+gender);
		
		String [] nemail = email.split("@"); // id 정보 가져오기 위해 @기준으로 문자열 자르기
		String nid = nemail[0];
		//System.out.println(nid);
		
		if(gender.equals("F")) {
			gender = new String("여");
		} else {
			gender = new String("남");
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
				if(cust.getWithdrawal() == 1)	// 탈퇴하지 않은 회원일 때만 로그인 가능하도록
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
		boolean result = false;
		
		List<OrderdetailDTO> list1 = null;
		try {
			list1 = odetail_service.checkorderdetail(itemid); // itemid로 예매내역 조회
			if(list1 != null) {
				for(OrderdetailDTO list : list1) {
					if(list.getCust_custid().equals(custid)) { // itemid로 예매내역 조회한것 중에 해당 custid의 예매내역이 존재할 경우
						result = true;
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
	public Object registerreview(Model model,  Integer itemid, String custid, String reviewcontent, Float reviewgrade) {
		boolean result = false;
		
		List<ReviewDTO> lastreview = null;
		try {
			lastreview = review_service.getitemreview(itemid);
			System.out.println(lastreview);
			if(lastreview == null || lastreview.isEmpty()) {  // 해당상품에 대한 리뷰를 작성한적이 없는 경우
				ReviewDTO review = new ReviewDTO(0,itemid,custid,reviewcontent,reviewgrade, null);
				review_service.register(review);
		
				result = true;
			} 
			else {
				for(ReviewDTO review : lastreview) {
					if(review.getCustid().equals(custid)) {  // 해당상품에 대한 리뷰를 작성한 적이 있는 경우
						result = false;
					} else {								// itemid에 대한 리뷰 중 해당회원이 작성한 리뷰는 없는 경우
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
