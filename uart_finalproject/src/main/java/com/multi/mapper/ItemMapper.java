package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ItemDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, ItemDTO>{
	public List<ItemDTO> select_cate(Integer k) throws Exception;
	public List<ItemDTO> searchitem(String txt) throws Exception;  //Service에 안써도 돼는 이유=> 트랜잭션이 필요없기 때문, 실패하면 데이터를 조회하지 못할 뿐 DB에 영향 없음. 데이터조작이 필요없음
	public List<ItemDTO> gethighgrade() throws Exception;
	public <V> V select2(Integer k) throws Exception;
	public <V> V select3(Integer k) throws Exception;
	public List<ItemDTO> start_fast(Integer k) throws Exception;  //Service에 없음
	public List<ItemDTO> end_fast(Integer k) throws Exception;  //Service에 없음

}