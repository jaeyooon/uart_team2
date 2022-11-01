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
public class OrderdetailDTO {

	private Integer orderdetailid;
	private Integer orderlistid;
	private Integer itemid;
	
	private String item_place;
	private Date item_estart;
	private Date item_efin;
	private String item_itemname;
	private Integer orderlist_ordercnt;
	private Date orderlist_orderdate;
	private Date orderlist_candate;
	private String cust_custid;
}
