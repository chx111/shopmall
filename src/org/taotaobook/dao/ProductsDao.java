package org.taotaobook.dao;

import java.util.List;

import org.taotaobook.entiy.Products;

public interface ProductsDao {

	
	public boolean addProduces(Products products);
	
	
	public boolean updateUser (Products products);
	
	
	public boolean isExit(String id);
	
	public Products selectAllInfo(String id);
	
	
	public List<Products> selectAllInfo();
	
	public List<Products> selectAll(String type);
	public boolean delectProduces(String id);
	
}
