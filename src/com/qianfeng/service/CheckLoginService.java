package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.CheckLoginDao;
import com.qianfeng.domain.shoppingUser;

public class CheckLoginService {

	public shoppingUser checkLogin(String uname, String password) throws SQLException {
		// ��ѯ�û��˺������Ƿ����
		CheckLoginDao dao=new CheckLoginDao();
		shoppingUser user= dao.checkLogin(uname, password);
		return user;
	}

}
