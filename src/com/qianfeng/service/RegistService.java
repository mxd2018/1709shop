package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.RegistDao;
import com.qianfeng.domain.shoppingUser;

public class RegistService {

	public void regist(shoppingUser shoppinguser) throws SQLException {
		// ÓÃ»§×¢²á
		RegistDao dao = new RegistDao();
		dao.regist(shoppinguser);
	}

	

}
