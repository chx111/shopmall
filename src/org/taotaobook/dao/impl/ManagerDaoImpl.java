package org.taotaobook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.taotaobook.dao.ManagerDao;
import org.taotaobook.entiy.Manager;
import org.taotaobook.entiy.Users;
import org.taotaobook.util.BaseDao;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {

	@Override
	public boolean addManager(Manager manager) {
		String sql="insert into manager (idcard,mphonenumber,msex,mname,mpassword) values (?,?,?,?,?)";
		Object[] params= {manager.getIdcard(),manager.getMphonenumber(),manager.getMsex(),manager.getMname(),manager.getMpassword()};
		return excuteUpdate(sql, params) ;
	}

	@Override
	public boolean updateManager(Manager manager) {
		String sql="update manager set mphonenumber=?,msex=?,mname=?,mpassword=? where idcard=?";
		Object[] params= {manager.getMphonenumber(),manager.getMsex(),manager.getMname(),manager.getMpassword(),manager.getIdcard()};
		return excuteUpdate(sql, params) ;
	}

	@Override
	public boolean isExit(String id) {
		if( selectAllInfo(id)==null)
			return false;
		else
			return true;
	}

	@Override
	public Manager selectAllInfo(String id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Manager manager=null;
		
		try {
			String sql="select * from manager where idcard=?";
			con=getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			if(rs.next()){
				String idcard=rs.getString("idcard");
				String mphonenumber=rs.getString("mphonenumber");
				String msex=rs.getString("msex");
				String mname=rs.getString("mname");
				String mpassword=rs.getString("mpassword");
				manager=new Manager(idcard, mphonenumber, msex, mname, mpassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return manager;
	}

	@Override
	public boolean selectLogin(String id, String passward) {
		Manager manager=selectAllInfo(id);
		if(manager!=null) {
			if(manager.getIdcard().equals(id) && manager.getMpassword().equals(passward)) 
				 return true;
			else
				return false;
		}else
			return false;
	}

}
