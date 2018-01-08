package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.qianfeng.domain.shoppingUser;
import com.qianfeng.utils.C3P0Utils;

public class RegistDao {

	public void regist(shoppingUser s) throws SQLException {
		// 往数据库添加注册用户
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
		/*http://localhost:8080/1709shop/registServlet
			?username=xiaoda&userpassword=123&realname=maxiaoda&
			email=1406988305%40qq.com&telephone=15168381503&addr=浙江杭州
			&birthday=1996年7月19日&sex=male&job=programmer&introduce=没有简介！*/
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into shoppinguser values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql,s.getUid(),s.getUname(),s.getUserpassword(),s.getRealname(),
				s.getEmail(),s.getTelephone(),s.getAddr(),s.getAddr2(),s.getBirthday(),s.getSex(),s.getJob(),
				s.getHobby(),s.getIntroduce(),s.getPicture());
	}

}
