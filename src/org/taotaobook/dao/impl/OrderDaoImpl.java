package org.taotaobook.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.taotaobook.dao.OrderDao;
import org.taotaobook.entiy.Link;
import org.taotaobook.entiy.Order;
import org.taotaobook.util.BaseDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public boolean orderAdd(Order order) {
		String sql = "insert into orders(id,address,money,user_id)values(?,?,?,?)";
		Object[] params = {order.getId(), order.getAddress(), order.getMoney(), order.getUser_id()};
		return excuteUpdate(sql, params);
	}

	@Override
	public boolean orderUpdete(Order order) {
		String sql = "update  orders set paystate=? where id=?";
		Object[] params = { order.getPaystate(), order.getId() };
		return excuteUpdate(sql, params);
	}

	@Override
	public List<Link> orderSelectAllInfo() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Link link=null;
		List <Link> links=new ArrayList<>();
		try {
			String sql = "select * from orders,orderitem where id = order_id";
			con = getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while(rs.next()) {
				String id=rs.getString("id");
				double money = Double.parseDouble(rs.getString("money"));
				int paystate=Integer.parseInt(rs.getString("paystate"));
				int user_id=Integer.parseInt(rs.getString("user_id"));;
				String address=rs.getString("address");
				String order_id=rs.getString("order_id");
				String product_id=rs.getString("product_id");
				int buynum=Integer.parseInt(rs.getString("buynum"));;
				
				link=new Link(id, money, paystate, user_id, address, order_id, product_id, buynum);
				links.add(link);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return links;
	}
	@Override
	public boolean orderUpdete(String id,double money) {
		String sql = "update  orders set money=? where id=?";
		Object[] params = { money, id};
		return excuteUpdate(sql, params);
	}
}
