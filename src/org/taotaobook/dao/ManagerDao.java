package org.taotaobook.dao;

import org.taotaobook.entiy.Manager;

public interface ManagerDao {

	//
	public boolean addManager(Manager manager);
	
	//
	public boolean updateManager(Manager manager);
	
	//
	public boolean isExit(String id);
	
	//
	public Manager selectAllInfo(String id);
	
	//
	public boolean selectLogin(String id,String passward);
}
