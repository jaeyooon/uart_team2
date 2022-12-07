package com.multi.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ChartDTO;
import com.multi.dto.ItemDTO;

@Repository
@Mapper
public interface AJAXMapper {
	public int getCustCnt();
	public List<ChartDTO> chart1();
	public List<ChartDTO> chart2(HashMap<String, Object> map);
	public List<ChartDTO> chart3();
	public List<ItemDTO> getname() throws Exception;
}
