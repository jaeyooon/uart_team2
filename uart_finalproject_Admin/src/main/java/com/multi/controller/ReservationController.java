package com.multi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.OrderdetailDTO;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	String dir = "reservation/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<OrderdetailDTO> list = null;
		
		
		
		return "main";
	}
	
	//리스트를 담아야 한다.
	

}






