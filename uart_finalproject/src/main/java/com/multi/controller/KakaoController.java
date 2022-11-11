package com.multi.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;
import com.multi.service.KakaoService;


@Controller
@RequestMapping("/oauth")
public class KakaoController {
	
	String dir = "cust/";
	
	@Autowired
	KakaoService service;
	
	@Autowired
	CustomerService cust_service;
	

    @GetMapping("/kakao")
    public String kakaologin(@RequestParam String code, Model model, HttpSession session) {
    	//System.out.println("#########" + code);
    	String access_Token = service.getAccessToken(code);
    	HashMap<String, Object> userInfo = service.getUserInfo(access_Token);
    	System.out.println(userInfo);
    	System.out.println("###access_Token : " + access_Token);
		System.out.println("###nickname: " + userInfo.get("nickname"));
		System.out.println("###email : " + userInfo.get("email"));
		System.out.println("###gender : " + userInfo.get("gender"));
		
		Object nickname = userInfo.get("nickname");
		String cname = String.valueOf(nickname); // Object를 String으로 변환
		//System.out.println(cname);
		
		Object kemail = userInfo.get("email");
		String kemail2 = String.valueOf(kemail);   // String형으로 변환
		String [] kemail3 = kemail2.split("@");  // @기준으로 문자열 자르기
		String kid = kemail3[0];
		
		Object kgender = userInfo.get("gender");
		String gender = String.valueOf(kgender);
		
		if(gender.equals("female")) { // 영어로 되어있는거 한국어로 바꿔서 db에 저장
			gender = new String("여");
		} else {
			gender = new String("남");
		}
		
		//System.out.println(email);
		CustomerDTO cust = null;
		try {
			cust = cust_service.get(kid);
			if(cust == null) {
				cust_service.register(new CustomerDTO(kid, null, cname, null, gender, kemail2, null, null, null));
				//System.out.println("OK");
				
				CustomerDTO newkakaocust = cust_service.get(kid);
				System.out.println(newkakaocust);
				
				session.setAttribute("logincust", newkakaocust);
				model.addAttribute("center", dir+"SNSregister"); 
			}
			else {
				session.setAttribute("logincust", cust);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "main";
    }
}
