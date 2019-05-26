package org.taotao.service.dao.impl;

import java.util.List;

import org.taotaobook.dao.ProductsDao;
import org.taotaobook.dao.impl.ProductsDaoImpl;
import org.taotaobook.entiy.Products;
import org.taotaobook.service.dao.ProducesService;

public class ProducesServiceimpl implements ProducesService{
	ProductsDao productsDao=new ProductsDaoImpl();
	@Override
	public boolean addProduces(Products products) {
		if(!productsDao.isExit(products.getId()))
			return productsDao.addProduces(products);
		return false;
	}

	@Override
	public boolean updateProduces(Products products) {
		
		return productsDao.updateUser(products);
	}

	@Override
	public boolean deleteProduces(String id) {
		return productsDao.delectProduces(id);
	}

	@Override
	public List<Products> SelectAllProducesInfo() {
		return productsDao.selectAllInfo();
	}

	@Override
	public Products SelectAllProducesInfo(String id) {
		return productsDao.selectAllInfo(id);
		
	}

	@Override
	public List<Products> selectAll(String type) {
		 return productsDao.selectAll(type);
	}

}
