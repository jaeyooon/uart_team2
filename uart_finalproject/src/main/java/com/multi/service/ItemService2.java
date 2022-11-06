package com.multi.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multi.dto.ItemDTO2;
import com.multi.frame.MyService;
import com.multi.mapper.ItemMapper2;
@Service
public class ItemService2 implements MyService<Integer, ItemDTO2>{
    @Autowired
    ItemMapper2 mapper;
    @Override
    public void register(ItemDTO2 v) throws Exception {
        mapper.insert(v);
        // TODO Auto-generated method stub
    }
    @Override
    public void remove(Integer k) throws Exception {
        mapper.delete(k);
        // TODO Auto-generated method stub
    }
    @Override
    public void modify(ItemDTO2 v) throws Exception {
        mapper.update(v);
        // TODO Auto-generated method stub
    }
    @Override
    public ItemDTO2 get(Integer k) throws Exception {
        // TODO Auto-generated method stub
        return mapper.select(k);
    }
    @Override
    public List<ItemDTO2> get() throws Exception {
        // TODO Auto-generated method stub
        return mapper.selectall();
    }
    public List<ItemDTO2> itemall2(Integer itemid) throws Exception {
		return mapper.itemall2(itemid);
	}
	
    
}