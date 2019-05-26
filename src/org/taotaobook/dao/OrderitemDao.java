package org.taotaobook.dao;

import java.util.List;

import org.taotaobook.entiy.Link;
import org.taotaobook.entiy.Orderitem;

public interface OrderitemDao {

	public boolean OrderitemAdd(Orderitem orderitem);
	
	public List<Link> OrderitemSelectInfo(int id);
}
