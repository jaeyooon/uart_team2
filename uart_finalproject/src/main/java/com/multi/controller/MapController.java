package com.multi.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {
	@RequestMapping({"/getmarker"})         //여기 데이터 있어요!
	public Object getmarker() {
		JSONArray ja = new JSONArray();
		JSONObject jo1 = new JSONObject();
		jo1.put("title", "사무실");
		jo1.put("target", "http://www.naver.com");
		jo1.put("lat", 37.52634620447252);
		jo1.put("lng", 127.04688364243283);
		ja.add(jo1);
		return ja;
	}
}