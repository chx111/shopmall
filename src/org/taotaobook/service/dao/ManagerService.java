package org.taotaobook.service.dao;

import org.taotaobook.entiy.Manager;

public interface ManagerService {
	public boolean addManager(Manager manager);

	//
	public boolean updateManager(Manager manager);

	//
	public Manager  selectAllInfo(String id);

	//
	public boolean selectLogin(String id, String passward);
}
