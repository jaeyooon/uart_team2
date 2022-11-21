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
	private String custid;
	private String item_itemname;
	private Date orderlist_orderdate;
	private Date item_estart;
	private Date item_efin;
	private Integer orderlist_ordercnt;
	private String item_itemimg;
	private String item_place;
	private Date orderlist_candate;
}
 