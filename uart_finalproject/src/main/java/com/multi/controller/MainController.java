package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/aboutus")
	public String aboutus(Model model) {
		model.addAttribute("center", "aboutus");
		return "main";
	}
	
	@RequestMapping("/recommend")
	public String recommend(Model model) {
		model.addAttribute("center", "recommenditem");
		return "main";
	}
	
	@RequestMapping("/event")
	public String event(Model model) {
		model.addAttribute("center", "eventlist");
		return "main";
	}
	
	@RequestMapping("/faq")
	public String faq(Model model) {
		model.addAttribute("center", "faq");
		return "main";
	}
	
	@RequestMapping("/wishlist")
	public String wishlist(Model model) {
		model.addAttribute("center", "wishlist");
		return "main";
	}
	
}