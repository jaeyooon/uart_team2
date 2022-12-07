package com.multi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.ChartDTO;
import com.multi.dto.ItemDTO;
import com.multi.mapper.AJAXMapper;
import com.multi.service.ItemService;

@RestController
public class AJAXController {

	@Autowired
	AJAXMapper mapper;
	
	@Autowired
	ItemService item_service;
	
	@RequestMapping("/custcnt")
	public String custcnt() {
		int cnt = mapper.getCustCnt();
		return cnt+"";
	}
	@RequestMapping("/chart2")
	public Object chart2(String ssm, String eem) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sm", ssm);
		map.put("em", eem);
		List<ChartDTO> list = null;
		list = mapper.chart2(map);
		// [{name:'',y:''},{}]
		JSONArray ja = new JSONArray();
		for(ChartDTO c:list) {
			JSONObject jo = new JSONObject();
			jo.put("name", c.getGender());
			jo.put("y", c.getTotal_price());
			ja.add(jo);
		}
		return ja;
	}
	
	@RequestMapping("/chart1")
	public Object chart1() {
		JSONObject result = new JSONObject();
		
		
		JSONArray ja = new JSONArray();
		JSONObject mobj = new JSONObject();
		JSONObject fobj = new JSONObject();
		mobj.put("name", "남자");
		fobj.put("name", "여자");
		
		JSONArray mja = new JSONArray();
		JSONArray fja = new JSONArray();
		
		List<ChartDTO> list = null;
		
		list = mapper.chart1();
		
		JSONArray month_ja = new JSONArray();
		int m = 0;
		for(ChartDTO c:list) {
			if(c.getGender().equals("남")) {
				mja.add(c.getTotal_price());
			}else{
				fja.add(c.getTotal_price());
				m++;
				month_ja.add(m);
			}
		}
		mobj.put("data", mja);
		fobj.put("data", fja);
		ja.add(mobj);
		ja.add(fobj);
		
		// [{},{}]
		// {"month":[1,2,3,4,5,6],"result":[{},{}]}
		result.put("month", month_ja);
		result.put("result", ja);
		return result;
	}
	
	@RequestMapping("/chart3")
	public Object chart3() {
		JSONObject result = new JSONObject();
		
		
		JSONArray ja = new JSONArray();
		JSONObject mobj = new JSONObject();
		JSONObject eobj = new JSONObject();
		JSONObject pobj = new JSONObject();
		JSONObject sobj = new JSONObject();
		JSONObject ieobj = new JSONObject();
		mobj.put("name", "미디어전시");
		eobj.put("name", "체험전시");
		pobj.put("name", "개인전시");
		sobj.put("name", "특별전시");
		ieobj.put("name", "공연예술전시");
		
		
		JSONArray mja = new JSONArray();
		JSONArray eja = new JSONArray();
		JSONArray pja = new JSONArray();
		JSONArray sja = new JSONArray();
		JSONArray ieja = new JSONArray();
		
		List<ChartDTO> list = null;
		
		list = mapper.chart3();
		
		JSONArray month_ja = new JSONArray();
		int m = 0;
		for(ChartDTO c:list) {
			if(c.getCateid().equals("1")) {
				mja.add(c.getTotal_price());
			}else if(c.getCateid().equals("2")) {
				eja.add(c.getTotal_price());
			}else if(c.getCateid().equals("3")) {
				pja.add(c.getTotal_price());
			}else if(c.getCateid().equals("4")) {
				sja.add(c.getTotal_price());
			}else if(c.getCateid().equals("5")) {
				ieja.add(c.getTotal_price());
				m++;
				month_ja.add(m);
			}
		}
		mobj.put("data", mja);
		eobj.put("data", eja);
		pobj.put("data", pja);
		sobj.put("data", sja);
		ieobj.put("data", ieja);
		ja.add(mobj);
		ja.add(eobj);
		ja.add(pobj);
		ja.add(sobj);
		ja.add(ieobj);
		
		result.put("month", month_ja);
		result.put("result", ja);
		System.out.println(month_ja);
		return result;
	}
	
	@RequestMapping("/getschedule")
	public List<Map<String, Object>> getschedule() {
		List<Map<String, Object>> schelist = new ArrayList<Map<String, Object>>();
		List<ItemDTO> list = null;
		
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		// [{"color":"", "start":"", "end":"", "title":"", "textColor":""},{},..]
		try {
			list = item_service.get();
			List<String> colorlist = new ArrayList<String>(); // 캘린더 이벤트 줄 색상
			
			colorlist.add("#fbf8cc");
			colorlist.add("#d8f3dc");
			colorlist.add("#ffcfd2");
			colorlist.add("#dee2ff");
			
			for(int i = 0; i < list.size(); i++) {
				Map<String, Object> sche = new HashMap<String, Object>();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				sche.put("title", list.get(i).getItemname());
				sche.put("start", sdf.format(list.get(i).getEstart()));
				sche.put("end", sdf.format(list.get(i).getEfin()));
				sche.put("textColor", "#003566");
				sche.put("color", colorlist.get(i%4));   
				sche.put("url", "http://101.101.219.170/admin/exhibition/get");   
				
				schelist.add(sche);
			}
			//System.out.println(schelist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return schelist;
	}
	@RequestMapping("/getdata")
	public Object getdata() throws Exception {
		int count = 6;
		int a=1;
		
		List<ItemDTO> list =null;
		list=item_service.gethighgrade();
		
		JSONArray ja = new JSONArray();
		for(ItemDTO c:list) {
			JSONObject jo = new JSONObject();
			jo.put("title", c.getItemname());
			
				jo.put("num", a++);
			
			ja.add(jo);
		}
		return ja;
}
	
	
	@RequestMapping("/autosearch")
	public Object autosearch() {
		List<ItemDTO> list=null;
		try {
			list=mapper.getname();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray ja=new JSONArray(); //배열선언
		
		for(ItemDTO i:list) {
			ja.add(i.getItemname()); //배열에 자료담기
		}
		return ja;
	}
	
}









