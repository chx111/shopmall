package org.taotaobook.entiy;

public class Manager {

	private String idcard;
	private String mphonenumber;
	private String msex;
	private String mname;
	private String mpassword;
	public Manager(String idcard, String mphonenumber, String msex, String mname, String mpassword) {
		this.idcard = idcard;
		this.mphonenumber = mphonenumber;
		this.msex = msex;
		this.mname = mname;
		this.mpassword = mpassword;
	}
	public Manager() {

	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMphonenumber() {
		return mphonenumber;
	}
	public void setMphonenumber(String mphonenumber) {
		this.mphonenumber = mphonenumber;
	}
	public String getMsex() {
		return msex;
	}
	public void setMsex(String msex) {
		this.msex = msex;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
}
