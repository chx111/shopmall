package org.taotaobook.service.dao;

import java.util.List;

import org.taotaobook.entiy.Products;

public interface ProducesService{

	/*
	 * 增加
	 */
	public boolean addProduces(Products products);
	
	/*
	 *更新 
	 */
	public boolean updateProduces(Products products);
	
	/*
	 * 删除
	 */
	public boolean deleteProduces(String id);
	
	/*
	 * 查询全部
	 */
	public List<Products>SelectAllProducesInfo();
	
	public Products SelectAllProducesInfo(String id);
	
	public List<Products> selectAll(String type);
}
