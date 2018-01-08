package com.qianfeng.domain;

public class shoppingUser {
	/*`uid` varchar(50) DEFAULT NULL,
	  `uname` varchar(50) DEFAULT NULL,
	  `userpassword` varchar(30) DEFAULT NULL,
	  `realname` varchar(30) DEFAULT NULL,
	  `email` varchar(50) DEFAULT NULL,
	  `telephone` varchar(50) DEFAULT NULL,
	  `addr` varchar(100) DEFAULT NULL,
	  addr2
	  `birthday` varchar(50) DEFAULT NULL,
	  `sex` varchar(10) DEFAULT NULL,
	  `job` varchar(30) DEFAULT NULL,
	  `hobby` varchar(50) DEFAULT NULL,
	  `introduce` varchar(200) DEFAULT NULL,
	  `picture` varchar(200) DEFAULT NULL*/
	private String uid;
	private String uname;
	private String userpassword;
	private String realname;
	
	private String email;
	private String telephone;
	private String addr;
	private String addr2;
	private String birthday;
	
	
	private String sex;
	private String job;
	private String hobby;
	private String introduce;
	private String picture;
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public shoppingUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "shoppingUser [uid=" + uid + ", uname=" + uname + ", userpassword=" + userpassword + ", realname="
				+ realname + ", email=" + email + ", telephone=" + telephone + ", addr=" + addr + ", birthday="
				+ birthday + ", sex=" + sex + ", job=" + job + ", hobby=" + hobby + ", introduce=" + introduce
				+ ", picture=" + picture + "]";
	}
	
	
	
}
