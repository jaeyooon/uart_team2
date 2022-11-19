package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService service;
	
	String dir = "admin/";
	
	@RequestMapping("/get")
	public String main(Model model) {
		List<AdminDTO> list = null;
		try {
			list = service.get();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center",dir+"get");
		return "main";
	}
	
	

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center",dir+"register");
		return "main";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, AdminDTO obj) throws Exception {	//변수명은 자유obj
		try {
			service.register(obj);
		} catch (Exception e) {
		
		}
		
		return "main";
	}

	@RequestMapping("/detail")
	public String detail(Model model, String adminid) {
		AdminDTO admin = null;
		try {
			admin = service.get(adminid);
			model.addAttribute("a",admin);
			model.addAttribute("center",dir+"detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, String adminid) {
		try {
			service.remove(adminid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:get";		// 삭제 후 전체조회로 가라
	}
	
	@RequestMapping("/update")
	public String update(Model model, AdminDTO adm) {
		try {
			service.modify(adm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail?adminid="+adm.getAdminid();
	}
	
}






