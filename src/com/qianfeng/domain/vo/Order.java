package com.qianfeng.domain.vo;

public class Order {
	
	private String oid;
	private String ordertime;
	private int pcount;
	private double totalprice;
	private String state;
	private String uno;
	

	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	
	
	public double getTotalprice() {
		return totalprice;
	}
	
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
