package org.taotaobook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.taotaobook.dao.ProductsDao;
import org.taotaobook.entiy.Products;
import org.taotaobook.util.BaseDao;

public class ProductsDaoImpl extends BaseDao implements ProductsDao {

	@Override
	public boolean addProduces(Products products) {
		String sql = "insert into products(id,name,writename,price,imgurl,description,type)values(?,?,?,?,?,?,?)";
		Object[] params = { products.getId(), products.getName(), products.getWritename(), products.getPrice(),
				products.getImgurl(), products.getDescription(), products.getType() };
		return excuteUpdate(sql, params);
	}

	@Override
	public boolean updateUser(Products products) {
		String sql = "update  products set  name=?,writename=?,price=?,imgurl=?,description=?,type=? where id=?";
		Object[] params = { products.getName(), products.getWritename(), products.getPrice(), products.getImgurl(),
				products.getDescription(), products.getType(), products.getId() };
		return excuteUpdate(sql, params);
	}

	@Override
	public Products selectAllInfo(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Products products = null;

		try {
			String sql = "select * from products where id=?";
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String idd = rs.getString("id");
				String name = rs.getString("name");
				String writename = rs.getString("writename");
				Double price = rs.getDouble("price");
				String imgurl = rs.getString("imgurl");
				String description = rs.getString("description");
				String type = rs.getString("type");

				products = new Products(id, name, writename, price, imgurl, description, type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public boolean delectProduces(String id) {
		String sql = "DELETE FROM  products where id=?";
		Object[] params = { id };
		return excuteUpdate(sql, params);
	}

	@Override
	public boolean isExit(String id) {
		if (selectAllInfo(id) == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Products> selectAllInfo() {
		List<Products> products = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Products product = null;

		try {
			String sql = "select * from products";
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String idd = rs.getString("id");
				String name = rs.getString("name");
				String writename = rs.getString("writename");
				Double price = rs.getDouble("price");
				String imgurl = rs.getString("imgurl");
				String description = rs.getString("description");
				String type = rs.getString("type");

				product = new Products(idd, name, writename, price, imgurl, description, type);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Products> selectAll(String type) {
		List<Products> products = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Products product = null;

		try {
			String sql = "select * from products where type=?";
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String writename = rs.getString("writename");
				Double price = rs.getDouble("price");
				String imgurl = rs.getString("imgurl");
				String description = rs.getString("description");
				String types = rs.getString("type");

				product = new Products(id, name, writename, price, imgurl, description, type);
				products.add(product);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}


}
