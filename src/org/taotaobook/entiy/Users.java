package org.taotaobook.entiy;

public class Users {
	
	private int id;
	private String phonenumber;
	private String sex;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Users(int id, String phonenumber, String sex, String username, String password) {
		this.id = id;
		this.phonenumber = phonenumber;
		this.sex = sex;
		this.username = username;
		this.password = password;
	}
	public Users(int id,  String password) {
		this.id = id;
		this.password = password;
	}
	public Users() {
		
	}
	
	


}
