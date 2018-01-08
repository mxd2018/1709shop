package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.domain.Product;
import com.qianfeng.utils.C3P0Utils;

public class BuyProductDao {

	public Product buyProduct(String pid) throws SQLException {
		// �����ݿ��в�ѯ��Ҫ�������Ʒ
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid=?";
		Product pro = qr.query(sql , new BeanHandler<Product>(Product.class),pid);
		return pro;
	}
	
}
