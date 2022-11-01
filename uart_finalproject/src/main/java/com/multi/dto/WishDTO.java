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
public class WishDTO {
	private Integer wishid;
	private String custid;
	private Integer itemid;
	
	//foreign 키로 추가된 것
	private String itemname;
	private String itemimg;
	
	

}