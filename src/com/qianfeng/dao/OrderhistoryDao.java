package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.domain.vo.Order;
import com.qianfeng.utils.C3P0Utils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class OrderhistoryDao {


	public List<Order> findOrders(String uid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from o_u_relation where uno=?";
		List<Order> orderhistory = qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
		return orderhistory;
	}

	public Order getOrder(String oid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from o_u_relation where oid=?";
		Order o = qr.query(sql, new BeanHandler<Order>(Order.class),oid);
		return o;
	}

}
