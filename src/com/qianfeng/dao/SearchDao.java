package com.qianfeng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.domain.Product;
import com.qianfeng.utils.C3P0Utils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class SearchDao {

	public List<Product> findProductListBySearch(String info) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product where pname like ? limit 0,?";
		List<Product> list = qRunner.query(sql, new BeanListHandler<Product>(Product.class),info+"%",4);
		//System.out.println(list);
		return list;
	}

}
