package com.multi.dto;

import java.sql.Date;

import com.multi.service.AdminService;

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
public class AdminDTO {
	private String adminid;
	private String adminpwd;
	private String aname;
	private String ademail;
	private String adphone;
	private String lev;
	public boolean isUseCookie() {
		// TODO Auto-generated method stub
		return false;
	}
	public AdminDTO login(AdminDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	public void keepLogin(String uid, String sessionId, Date next) {
		// TODO Auto-generated method stub
		
	}
	public AdminDTO checkUserWithSessionKey(String sessionId) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}