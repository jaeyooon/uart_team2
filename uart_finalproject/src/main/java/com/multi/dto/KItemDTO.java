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
public class KItemDTO {
	private Integer itemid;
	private Integer cateid;
	private String itemname;
	private String itemimg;
	private String itemplace;
	private double lat;
	private double lng;
	private String itemguide;
	private String itemticket;
	private Integer itemstock;
	private Date estart;
	private Date efin;
	
	private String obj;
	private Integer price;
	private String catename;

}
