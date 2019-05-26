package org.taotaobook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.taotaobook.dao.OrderitemDao;

import org.taotaobook.entiy.Link;
import org.taotaobook.entiy.Orderitem;
import org.taotaobook.util.BaseDao;

public class OrderitemDaoImpl extends BaseDao implements OrderitemDao {

	@Override
	public boolean OrderitemAdd(Orderitem orderitem) {
		String sql="insert into orderitem(order_id,product_id,buynum)values(?,?,?)";
		Object[] params = {orderitem.getOrder_id(),orderitem.getProduct_id(),orderitem.getBuynum()};
		return excuteUpdate(sql, params);
	}

	@Override
	public List<Link> OrderitemSelectInfo(int idd) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Link link=null;
		List<Link>links=new ArrayList<>();
		try {
			String sql = "select * from orders,orderitem where id=order_id and user_id=?";
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,idd);
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

}
