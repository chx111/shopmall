package org.taotaobook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.taotaobook.dao.userDao;
import org.taotaobook.entiy.Users;
import org.taotaobook.util.BaseDao;

public class userDaoImpl extends BaseDao implements userDao {
	@Override
	public boolean addUser(Users user) {
		
		String sql="insert into users(id,phonenumber,sex,username,password) values (?,?,?,?,?)";
		Object[] params= {user.getId(),user.getPhonenumber(),user.getSex(),user.getUsername(),user.getPassword()};
		return excuteUpdate(sql, params) ;
	}

	@Override
	public boolean updateUser(Users user) {
		
		String sql="update users set username=?,phonenumber=?,sex=?,password=? where id=?";
		Object[] params= {user.getUsername(),user.getPhonenumber(),user.getSex(),user.getPassword(),user.getId()};
		return excuteUpdate(sql, params) ;
	}

	@Override
	public boolean isExit(int id) {
		if( selectAllInfo(id)==null)
			return false;
		else
			return true;
	}

	@Override
	public Users selectAllInfo(int id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Users user=null;
		
		try {
			String sql="select * from users where id=?";
			con=getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			if(rs.next()){
				int idd=rs.getInt("id");
				String name=rs.getString("username");
				String phonenumber=rs.getString("phonenumber");
				String sex=rs.getString("sex");
				String passward=rs.getString("password");
				user=new Users(idd,phonenumber,sex,name,passward);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean selectLogin(int id, String passward) {
		Users user=selectAllInfo(id);
		if(user!=null) {
			if(user.getId()==id &&user.getPassword().equals(passward)) 
				 return true;
			else
				return false;
		}else
			return false;
	}

}
