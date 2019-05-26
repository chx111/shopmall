package org.taotaobook.dao;

import org.taotaobook.entiy.Users;

public interface userDao {
	/*
	 * @����û�
	 */
	public boolean addUser(Users user);
	
	/*
	 * @�����û���Ϣ
	 */
	public boolean updateUser (Users user);
	
	
	/*
	 * @�ж��û��Ƿ����
	 */
	public boolean isExit(int id);
	/*
	 * @�����û�������Ϣ
	 */
	public Users selectAllInfo(int id);
	
	public boolean selectLogin(int id,String passward);
	
	
}
