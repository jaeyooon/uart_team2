package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	CustomerService service;
	String dir = "cust/";
	
	@RequestMapping("/registered")   
	public String register(Model model) {
		model.addAttribute("center", dir+"register");  /*폴더 안에 register가 있어서?(cust/register)*/
		return "main";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, CustomerDTO cust, HttpSession session) {
		try {
			System.out.println(cust);
			service.register(cust);
			session.setAttribute("logincust", cust);
			model.addAttribute("center",dir+"registerok");
			model.addAttribute("rid",cust);
		} catch (Exception e) {
			model.addAttribute("center",dir+"registerfail");
			model.addAttribute("fid",cust);
		}
		return "main";
	}
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result ="";
		CustomerDTO cust = null;
		try {
			service.get(cid);
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
}
