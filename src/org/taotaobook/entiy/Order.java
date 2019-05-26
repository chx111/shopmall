package org.taotaobook.entiy;

public class Order {
	
	private String id;
	private double money;
	private int paystate;
	private int user_id;
	private String address;
	
	public Order(String id, double money, int paystate, int user_id, String address) {
		this.id = id;
		this.money = money;
		this.paystate = paystate;
		this.user_id = user_id;
		this.address = address;
	}
	public Order(String id, int paystate) {
		this.id = id;
		this.paystate = paystate;
	}
	public Order(String id, double money,  int user_id, String address) {
		this.id = id;
		this.money = money;
		this.user_id = user_id;
		this.address = address;
	}
	
	public Order() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getPaystate() {
		return paystate;
	}
	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
