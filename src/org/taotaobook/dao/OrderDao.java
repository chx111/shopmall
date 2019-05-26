package org.taotaobook.dao;

import java.util.List;

import org.taotaobook.entiy.Link;
import org.taotaobook.entiy.Order;

public interface OrderDao {
	
	//
	public boolean orderAdd(Order order);
	
	//
	public boolean orderUpdete(Order order);
	
	//
	public List <Link> orderSelectAllInfo();
	
	//
	public boolean orderUpdete(String id,double money);
	
}
