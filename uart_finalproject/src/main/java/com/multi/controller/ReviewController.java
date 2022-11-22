package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	/*
	 * @RequestMapping("/registerreview") public String registerreview(Model model,
	 * Integer itemid, String custid, String reviewcontent, Float reviewgrade) {
	 * ReviewDTO review = new ReviewDTO(0,itemid,custid,reviewcontent,reviewgrade,
	 * null); try { service.register(review); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return "redirect:item/itemdetail?itemid="+itemid; }
	 */
}
