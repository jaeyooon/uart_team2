package com.multi.dto;

import java.util.Date;

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
	private Date udate;
	private String content;
	private String image;
	private Date tdate;
	private int sale;
}