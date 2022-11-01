package com.multi.dto;

import java.util.Date;

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
public class CustomerDTO {
	private String custid;
	private String pwd;
	private String cname;
	private String birth;
	private String gender;
	private String email;
	private String phone;
	private Date custdate;
	private Integer withdrawal;
	
}