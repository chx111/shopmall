package org.taotao.service.dao.impl;

import org.taotaobook.dao.userDao;
import org.taotaobook.dao.impl.userDaoImpl;
import org.taotaobook.entiy.Users;
import org.taotaobook.service.dao.UserService;

public class UserServiceimpl implements UserService{
	userDao userdao=new userDaoImpl();
	@Override
	public boolean addUser(Users user) {
		if(!userdao.isExit(user.getId())) {
			userdao.addUser(user);
			return true;
		}else {
			return false;
		}

	}
	@Override
	public boolean updateUser(Users user) {
		if(userdao.isExit(user.getId())) {
			return  userdao.updateUser(user);
		}else {
			return false;
		}
	}


	@Override
	public Users selectAllInfo(int id) {
		return userdao.selectAllInfo(id);
	}

	@Override
	public boolean selectLogin(int id, String passward) {
		return userdao.selectLogin(id, passward);
	}

}
