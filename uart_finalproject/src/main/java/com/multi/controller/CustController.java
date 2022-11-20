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
		// session을 거절하고 다시 main으로 보냄!
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", dir + "login");
		return "main";
	}

	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, Model model, String custid, String pwd) {
		CustomerDTO cust = null;
		try {
			cust = cust_service.get(custid);
			if (cust.getWithdrawal() == 1) {
				if (pwd.equals(cust.getPwd())) {
					session.setAttribute("logincust", cust);
					model.addAttribute("center", "main");
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping("/detail")
	public String detail(String custid, Model model) {
		CustomerDTO cust = null;
		try {
			cust = cust_service.get(custid);
			model.addAttribute("cust", cust);
			model.addAttribute("center", dir + "detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";

	}

	@RequestMapping("/update")
	// id를 입력으로 받아와랴 해당하는 회원의 detail정보를 불러올 수 있음
	public String update(Model model, String custid) {
		CustomerDTO cust = null;
		try {
			cust = cust_service.get(custid);
			// select해온 값을 담아서
			model.addAttribute("cust", cust);
			// centerpage는 이친구임(cust)의 정보를 가지고 있는!!
			// 수정하는 화면으로 이동한다.
			model.addAttribute("center", dir + "update");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

	@RequestMapping("/custupdateimpl")
	public String custupdateimpl(Model model, CustomerDTO cust) {
		// 수정한 이후에 detail 페이지로 이동
		try {
			cust_service.modify(cust);
		} catch (Exception e) { // 비정상일때
			e.printStackTrace();
		}
		return "redirect:detail?custid=" + cust.getCustid(); // controller 안에서 controller를 이렇게 호출함
	}

	@RequestMapping("/withdraw")
	// id를 입력으로 받아와랴 해당하는 회원의 detail정보를 불러올 수 있음
	public String withdraw(Model model, String custid) {
		CustomerDTO cust = null;
		try {
			cust = cust_service.get(custid);
			// select해온 값을 담아서
			model.addAttribute("cust", cust);
			// centerpage는 이친구임(cust)의 정보를 가지고 있는!!
			// 수정하는 화면으로 이동한다.
			model.addAttribute("center", dir + "withdraw");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";

	}

	@RequestMapping("/withdrawimpl")
	// id를 입력으로 받아와랴 해당하는 회원의 detail정보를 불러올 수 있음
	public String custwithdrawimpl(Model model, CustomerDTO cust, HttpSession session) {

		try {
			cust_service.delete1(cust);
			if (session != null) {
				session.invalidate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// controller안에서 다른 controller호출할 때
		return "main";
	}

}