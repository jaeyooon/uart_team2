package com.multi.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.multi.dto.AdminDTO;
import com.multi.mapper.AdminDAO;
 
@Repository
public class AdminDTOImpl implements AdminDAO {
    @Inject
    SqlSession sqlSession;
 
    /**
     * login에 성공하면, 유저 정보를 담고 있는 UserVO 객체를 반환한다.
     */
    @Override
    public AdminDTO login(AdminDTO dto) {
        // Mapper의 namespace명.id : 자신에게 맞게 작성해서 넣는다.
        return sqlSession.selectOne("com.multi.mapper.AdminMapper.login", dto);
    }
 
    // 자동로그인 체크한 경우에 사용자 테이블에 세션과 유효시간을 저장하기 위한 메서드
    public void keepLogin(String uid, String sessionId, Date next){
         
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userId", uid);
        map.put("sessionId", sessionId);
        map.put("next", next);
         
        // Mapper.xml로 데이터를 전달할 때 한 객체밖에 전달 못함으로 map으로 묶어서 보내줌 단... 주의할 점은
        // Mapper.xml 안에서 #{} 이 안에 지정한 이름이랑 같아야함.. 자동으로 매핑될 수 있도록
        // 아래가 수행되면서, 사용자 테이블에 세션id와 유효시간이 저장됨
        sqlSession.update("com.multi.mapper.AdminMapper.keepLogin",map);
         
    }
 
    // 이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크한다.
    public AdminDTO checkUserWithSessionKey(String sessionId){
        // 유효시간이 남아있고(>now()) 전달받은 세션 id와 일치하는 사용자 정보를 꺼낸다.
        return sqlSession.selectOne("com.multi.mapper.AdminMapper.checkUserWithSessionKey",sessionId);
     
    }
     
 
}
