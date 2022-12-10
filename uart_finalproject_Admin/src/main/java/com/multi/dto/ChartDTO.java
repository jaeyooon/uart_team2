package com.multi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ChartDTO {
	private String DateRange;
	private String month;
	private String year;
	private String gender;
	private int total_price;
	
	private String cateid; 
	private String catename;
	private int itemid;
	private int orderlistid;
}
