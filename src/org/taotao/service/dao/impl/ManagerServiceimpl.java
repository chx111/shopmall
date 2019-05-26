package org.taotao.service.dao.impl;

import org.taotaobook.dao.ManagerDao;
import org.taotaobook.dao.impl.ManagerDaoImpl;
import org.taotaobook.entiy.Manager;
import org.taotaobook.service.dao.ManagerService;

public class ManagerServiceimpl implements ManagerService {
	ManagerDao managerDao=new ManagerDaoImpl();
	@Override
	public boolean addManager(Manager manager) {
		if(!managerDao.isExit(manager.getIdcard())) {
			managerDao.addManager(manager);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateManager(Manager manager) {
		
		return managerDao.updateManager(manager);
	}

	@Override
	public Manager selectAllInfo(String id) {
		return managerDao.selectAllInfo(id);
	}

	@Override
	public boolean selectLogin(String id, String passward) {
		return managerDao.selectLogin(id, passward);
	}

}
