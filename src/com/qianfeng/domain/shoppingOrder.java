package com.qianfeng.domain;

public class shoppingOrder {
	/*oid` varchar(100) DEFAULT NULL,
	  `ordertime` varchar(100) DEFAULT NULL,
	  `buyername` varchar(50) DEFAULT NULL,
	  `addr` varchar(50) DEFAULT NULL,
	  `addr2` varchar(100) DEFAULT NULL,
	  `telephone` varchar(30) DEFAULT NULL,
	  `state` varchar(30) DEFAULT NULL,
	  `pnumber` varchar(100) DEFAULT NULL
	  totalprice
	  */
	private String oid;
	private String ordertime;
	private String buyername;
	private String pname;
	private String pimg;
	private String addr;
	private String addr2;
	private String telephone;
	private String state;
	private double totalprice;
	
	

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



	public String getBuyername() {
		return buyername;
	}



	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	
	



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}
	
	


	public String getPimg() {
		return pimg;
	}



	public void setPimg(String pimg) {
		this.pimg = pimg;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public String getAddr2() {
		return addr2;
	}



	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}

	public double getTotalprice() {
		return totalprice;
	}



	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}



	public shoppingOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
