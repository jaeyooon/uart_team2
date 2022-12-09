package com.multi.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;


@Controller
public class MainController {
	
	@Autowired
	AdminService service;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center","login");
		return "main";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, String adminid, String adminpwd) {
		AdminDTO adm = null;
		try {
			adm = service.get(adminid);
			if(adm != null) {
				if(adm.getAdminpwd().equals(adminpwd)) {
				session.setAttribute("loginadmin", adm);
				}
			}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
		return "main";				//로그인 하고 메인으로
	}
	
	@RequestMapping("/logout")
	public String loginimpl(HttpSession session) {
		if(session != null) {
			session.invalidate();			//로그아웃 시키고 메인으로
		}
		return "redirect:/";	
	}
}