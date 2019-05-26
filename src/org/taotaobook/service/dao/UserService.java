package org.taotaobook.service.dao;

import org.taotaobook.entiy.Users;

public interface UserService {
	public boolean addUser(Users user);

	//
	public boolean updateUser(Users user);

	//
	//public boolean isExit(int id);

	//
	public Users selectAllInfo(int id);

	//
	public boolean selectLogin(int id, String passward);
}
