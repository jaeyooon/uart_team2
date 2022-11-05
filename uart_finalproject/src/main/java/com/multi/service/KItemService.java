package com.multi.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multi.dto.KItemDTO;
import com.multi.dto.WishlistDTO;
import com.multi.frame.MyService;
import com.multi.mapper.KItemMapper;
@Service
public class KItemService implements MyService<Integer, KItemDTO>{
    @Autowired
    KItemMapper mapper;
    @Override
    public void register(KItemDTO v) throws Exception {
        mapper.insert(v);
        // TODO Auto-generated method stub
    }
    @Override
    public void remove(Integer k) throws Exception {
        mapper.delete(k);
        // TODO Auto-generated method stub
    }
    @Override
    public void modify(KItemDTO v) throws Exception {
        mapper.update(v);
        // TODO Auto-generated method stub
    }
    @Override
    public KItemDTO get(Integer k) throws Exception {
        // TODO Auto-generated method stub
        return mapper.select(k);
    }
    @Override
    public List<KItemDTO> get() throws Exception {
        // TODO Auto-generated method stub
        return mapper.selectall();
    }
    public List<KItemDTO> kitemall(Integer itemid) throws Exception {
		return mapper.kitemall(itemid);
	}
	
    
}