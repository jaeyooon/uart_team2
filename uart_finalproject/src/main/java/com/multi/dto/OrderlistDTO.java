package com.multi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderlistDTO {

	private Integer orderlistid;
	private Integer itemid;
	private String custid;
	private Date orderdate;
	private Integer ordercnt;
	private Integer totalprice;
	private String pay;
	private String phone2;
	private Date candate;
	
	private String item_itemname;
	private String cust_cname;
}
