package org.taotaobook.entiy;

import java.util.ArrayList;
import java.util.List;

public class Linkitem {
	private String id;
	private int paystate;
	private int user_id;
	private List<item> it=new ArrayList<>();
	private double money;
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Linkitem(String id, int paystate, int user_id, List<item> it, double money) {
		super();
		this.id = id;
		this.paystate = paystate;
		this.user_id = user_id;
		this.it = it;
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public List<item> getIt() {
		return it;
	}
	public void setIt(List<item> it) {
		this.it = it;
	}
	public Linkitem(String id, int paystate, int user_id, List<item> it) {
		this.id = id;
		this.paystate = paystate;
		this.user_id = user_id;
		this.it = it;
	}
	public Linkitem() {
	}
	
	
	
}
