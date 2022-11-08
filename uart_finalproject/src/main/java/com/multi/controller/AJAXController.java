package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CustomerDTO;
import com.multi.dto.EmanageDTO;
import com.multi.dto.EventblDTO;
import com.multi.frame.Util;
import com.multi.ncp.OCR;
import com.multi.service.CustomerService;
import com.multi.service.EmanageService;
import com.multi.service.EventblService;

@RestController
public class AJAXController {

	@Autowired
	CustomerService cust_service;
	
	@Autowired
	EmanageService emanage_service;
	
	@Autowired
	EventblService event_service;
	
	@Value("${custdir}")
	String custdir;
	
	@Autowired
	OCR ocr;
	
	
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
				event_service.register(new EventblDTO(null, custid, null, null, null, null, null, null,null));
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	
}
