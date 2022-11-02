package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustController {

	String dir = "cust/";
	
	@Autowired
	CustomerService cust_service;
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session을 거절하고 다시 main으로 보냄!
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", dir+"login");
		return "main";
	}
	
	@RequestMapping("/loginimpl")
	   public String loginimpl(HttpSession session, String custid, String pwd) {
	      CustomerDTO cust = null;
	      try {
	         cust = cust_service.get(custid);
	         if(cust != null) {
	            if(cust.getPwd().equals(pwd)) {
	               session.setAttribute("logincust", cust); 
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	        
	      }
	      return "redirect:/";
	   }
	
	
	
}