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
public class ReviewDTO {
	private Integer reviewid;
	private Integer itemid;
	private String custid;
	private String reviewcontent;
	private Double reviewgrade;
	private Date reviewdate;
}