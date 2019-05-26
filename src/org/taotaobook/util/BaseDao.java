package org.taotaobook.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BaseDao { 
	private String driver = "com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/estoresystem?userUnicode=true&characterEncoding=utf-8";
	public Connection getConnection(){
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root","root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void CloseAll(Connection con,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(con!=null)
				con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean excuteUpdate(String sql,Object[] param){
		Connection con=getConnection();
		PreparedStatement ps=null;
		int res=0;
		try{
		ps = con.prepareStatement(sql);
	
		if(param!=null){
		   for(int i=0;i<param.length;i++){
			   ps.setObject(i+1, param[i]);
		   }
		}
		
		res=ps.executeUpdate();
		if(res>0){
			System.out.println("³É¹¦");
			return true;
		}else{
			System.out.println("Ê§°Ü");
			return false;
		}
		
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			CloseAll(con, ps, null);
		}
		
		
	}
}
