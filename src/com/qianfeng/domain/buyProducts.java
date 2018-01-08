package com.qianfeng.domain;

public class buyProducts {
	//uname,telephone,add,add2,pname,market_price,pimage,pdesc
	private String uname;
	private String telephone;
	private String addr;
	private String addr2;
	
	private String pname;
	private String market_price;
	private String pimage;
	private String pdesc;
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getMarket_price() {
		return market_price;
	}
	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public buyProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "buyProducts [uname=" + uname + ", telephone=" + telephone + ", addr=" + addr + ", addr2=" + addr2
				+ ", pname=" + pname + ", market_price=" + market_price + ", pimage=" + pimage + ", pdesc=" + pdesc
				+ "]";
	}
	
	
	
}
