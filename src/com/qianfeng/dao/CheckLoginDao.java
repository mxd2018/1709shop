package com.qianfeng.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.domain.shoppingUser;
import com.qianfeng.utils.C3P0Utils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CheckLoginDao {

	public shoppingUser checkLogin(String uname, String password) throws SQLException {
		// 从数据库中查询账户是否存在，密码是否正确
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select *  from shoppinguser where uname=? and userpassword=?";
		shoppingUser user = qRunner.query(sql, new BeanHandler<shoppingUser>(shoppingUser.class),uname,password);
		return user;
	}

	public shoppingUser checkLogin(String uname) throws SQLException {
		QueryRunner qr= new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from shoppinguser where uname=?";
		return qr.query(sql, new BeanHandler<shoppingUser>(shoppingUser.class),uname);
		
	}

}
