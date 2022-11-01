package com.multi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemoptionDTO {
	private Integer optionid;
	private Integer itemid;
	private String obj;
	private Integer price;
}