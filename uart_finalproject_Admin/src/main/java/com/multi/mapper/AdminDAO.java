package com.multi.mapper;

import java.sql.Date;

import com.multi.dto.AdminDTO;
 
public interface AdminDAO {
 
    public AdminDTO login(AdminDTO dto);
     
    // 자동로그인 체크한 경우에 사용자 테이블에 세션과 유효시간을 저장하기 위한 메서드
    public void keepLogin(String uid, String sessionId, Date next);
     
    // 이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크한다.
    public AdminDTO checkUserWithSessionKey(String sessionId);
     
}
