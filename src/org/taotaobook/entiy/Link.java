package org.taotaobook.entiy;

public class Link {
	private String id;
	private double money;
	private int paystate;
	private int user_id;
	private String address;
	private String order_id;
	private String product_id;
	private int buynum;
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
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	public Link(String id, double money, int paystate, int user_id, String address, String order_id, String product_id,
			int buynum) {
		this.id = id;
		this.money = money;
		this.paystate = paystate;
		this.user_id = user_id;
		this.address = address;
		this.order_id = order_id;
		this.product_id = product_id;
		this.buynum = buynum;
	}
	public Link() {
		
	}
	
}
