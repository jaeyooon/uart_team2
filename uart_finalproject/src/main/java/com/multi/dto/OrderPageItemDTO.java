package com.multi.dto;

import java.util.Date;
import java.util.List;

public class OrderPageItemDTO {
	
	/* 뷰로부터 전달받을 값 */
    private Integer itemid;
    private String custid;
    
    private Integer itemcnt1;
    private Integer itemcnt2;
    private Integer itemcnt3;
    
	/* DB로부터 꺼내올 값 */
    private String itemname;
    private String itemimg;
    private String email;
    private String name;
	private String phone;
    
    private String itemoption_obj1;
	private Integer itemoption_price1;
	private String itemoption_obj2;
	private Integer itemoption_price2;
	private String itemoption_obj3;
	private Integer itemoption_price3;
    
    
	/* 만들어 낼 값 */
    private Integer totalprice;
    private Integer inttotalprice;
    private Integer sale_totalprice;
    private Integer ordercnt;
    private Integer intordercnt;
    private Date candate;
    
	
    
}
