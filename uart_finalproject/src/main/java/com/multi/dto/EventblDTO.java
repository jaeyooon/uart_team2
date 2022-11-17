package com.multi.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventblDTO {
	private Integer eid;
	private String custid;
	private Date sdate;
	private Date fdate;
	private String content;
	private String image;
	private Integer sale;
	private Date pdate;
	private Integer sort;
	
	private MultipartFile uploadimg; // 수험표 업로드한 이미지
}