package com.multi.service;

import java.sql.Date;

import javax.inject.Inject;
 
import org.springframework.stereotype.Service;
import com.multi.dto.AdminDTO;
import com.multi.mapper.AdminDAO;
import com.multi.mapper.AdminService;
 
@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject
	AdminDAO dao;
	
	@Override
	public AdminDTO login(AdminDTO dto) {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) {
		// TODO Auto-generated method stub
		dao.keepLogin(uid, sessionId, next);
	}

	@Override
	public AdminDTO checkUserWithSessionKey(String sessionId) {
		// TODO Auto-generated method stub
		return dao.checkUserWithSessionKey(sessionId);
	}
	
}