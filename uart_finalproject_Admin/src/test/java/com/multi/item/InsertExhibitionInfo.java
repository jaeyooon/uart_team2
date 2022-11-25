package com.multi.item;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.multi.dto.ItemDTO;
import com.multi.dto.ItemoptionDTO;
import com.multi.mapper.ItemMapper;
import com.multi.mapper.ItemoptionMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


@SpringBootTest
public class InsertExhibitionInfo {
	
	@Autowired
	ItemMapper item_mapper;
	
	@Autowired
	ItemoptionMapper itemoption_mapper;
	
	@Test
	void contextLoads() throws Exception {
		String key = "3nqSD49np6RtAQPeomqrJE6PxgVHA4EtS9nXhYruv%2FcptxAs4Qa2jvQHE3klp2%2FlaOixhSEPeVESzpgw8dcHKQ%3D%3D";
		
		String apiurl = "http://www.culture.go.kr/openapi/rest/publicperformancedisplays/period?"
				+ "&ServiceKey="+key
				+ "&sortStdr=1"
				+ "&from=20210101"
				+ "&to=20230228"
				+ "&cPage=1"
				+ "&rows=17"
				+ "&gpsxfrom=120.0"
				+ "&gpsyfrom=30.0"
				+ "&gpsxto=130.0"
				+ "&gpsyto=40.0"
				+ "&place=1"
				;

		String parsingUrl = ""; // Parsiong 할 URL
		
		//* URL 객체 생성후 URL을 호출하기 위한 코드 작성  
		// setRequestMethod : 응답 방식 - GET , setRequestProperty : 응답 헤더 - application/json 방식
		URL url = new URL(apiurl);
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		//응답 코드 : conn.getResponseCode()
		System.out.println("Response Code : "+ conn.getResponseCode());
		
		
		//* 응답 코드 성공 여부에 따라 분기 설정
		// URL 로 응답 받은 데이터 값은 inputstream 으로 꺼낼 수 있다.
		
		BufferedReader rd; // InputStreamReader 값을 담을 Reader버퍼함수
		
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <=300 ) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuffer sb = new StringBuffer();
		String line; 
		
		while ((line = rd.readLine()) != null) 
		{ 
			sb.append(line); 
		} 
	
		rd.close(); // ReaderBufferd 닫기
		
		conn.disconnect(); //HttpURLConnection 닫기
		System.out.println(sb.toString());
		
		//* XML 을 DATA로 옴기기 위한 코드
		
		//페이지에 접근해줄 Document객체 생성 
		//doc객체를 통해 파싱할 url의 요소를 읽어들인다. 
		//doc.getDocumentElement().getNodeName()을 출력하면 위 xml의 최상위 태그를 가져온다.

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
		
		parsingUrl = url.toString();
		Document doc = dBuilder.parse(parsingUrl);

		
		//root tag 
		
		// Tree 구조 node 로 변환
		doc.getDocumentElement().normalize();
		
		// root tag 값 확인
		System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
		
		// 파싱할 데이터 tag 의 리스트 수
		NodeList nList = doc.getElementsByTagName("perforList"); // <item> 태그요소
		
		System.out.println("파싱할 리스트 수 : " +  nList.getLength());
		
		int itemid = 123;
		int numbering = 0; // 이미지 저장할 때 넘버링
		for(int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i); // <item> i 의 값을 nNode 에 넣는다.
			
			//Element node type 비교
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				
//				 System.out.println("========================");
//				 System.out.println(getTagValue("seq", eElement));
//				 System.out.println(getTagValue("title", eElement));
//				 System.out.println(getTagValue("startDate", eElement));
//				 System.out.println(getTagValue("endDate", eElement));
//				 System.out.println(getTagValue("place", eElement));
//				 System.out.println(getTagValue("realmName", eElement)); //
//				 System.out.println(getTagValue("area", eElement));
//				 System.out.println(getTagValue("thumbnail", eElement));
//				 System.out.println(getTagValue("gpsX", eElement));
//				 System.out.println(getTagValue("gpsY", eElement));
				
				
				itemid += 1;
				numbering += 1;
				
				
				//ItemDTO 컬럼 명이랑 형 똑같이
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				
				int seq =  Integer.parseInt(getTagValue("seq", eElement));
				String itemname = getTagValue("title", eElement);
				Date estart = formatter.parse(getTagValue("startDate", eElement));
				Date efin = formatter.parse(getTagValue("endDate", eElement));
				String itemplace = getTagValue("place", eElement);
				String itemplace_address = getTagValue("place", eElement);
				String itemimgURL = getTagValue("thumbnail", eElement);
				Double lat = Double.parseDouble(getTagValue("gpsY", eElement));
				Double lng = Double.parseDouble(getTagValue("gpsX", eElement));
				
				System.out.println(itemimgURL);
				
				try {
				
				String extension = itemimgURL.substring(itemimgURL.lastIndexOf(".")+1); // 확장자
				String itemimg = "artimg" + Integer.toString(numbering) + "." + extension;
				System.out.println(itemimg);  // ------- db에 저장될 이미지 문자열 이름
					
				// db에 공공 데이터 INSERT
				ItemDTO newitem = new ItemDTO(null, 5, itemname, itemimg, itemplace, itemplace_address, lat, lng, "전체관람가", "온라인수령", 200, estart, efin, null, null, null, null, null, null, null, null, null, null, null);
				item_mapper.insert(newitem);
				itemoption_mapper.insert(new ItemoptionDTO(null, itemid, "어른", 10000, "청소년", 8000, "어린이", 5000));
				
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
				
//				System.out.println("=== ItemDTO에 넣을 값 확인 ================");
//				System.out.println(seq);
//				System.out.println(itemname);
//				System.out.println(estart);
//				System.out.println(efin);
//				System.out.println(itemplace);
//				System.out.println(itemplace_address);
//				System.out.println(fileName);
//				System.out.println(lat);
//				System.out.println(lng);
//				
//				
//				
				
				}
			}
			System.out.println("OK");
		}
	
		//*tag 값의 정보를 가져오는 메소드
		private static String getTagValue(String tag, Element eElement) {
			
			NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
			Node nValue = (Node)nList.item(0);
			
			if(nValue == null) {
				return null;
			}
			return nValue.getNodeValue();
			
		}
		
}
