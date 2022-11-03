package com.multi.dto;

import java.util.*;

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
public class WishlistDTO {
	private Integer wishid;
	private String custid;
	private Integer itemid;
	
	
	//foreign 키로 추가된 것
	private String itemname;
	private String itemimg;
	
	//임의로 추가
	private Date estart;
	private Date efin;
	private Date wishdate;
	

}