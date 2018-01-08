package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.domain.Product;
import com.qianfeng.utils.C3P0Utils;

public class ShoppingCarDao {

	public Product showShoppingCarProduct(String id) throws SQLException {
		// ����session��ȡ����id���ӹ��ﳵ��ѯ��Ʒ
		QueryRunner qq = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product where pid=?";
		
			Product p = qq.query(sql, new BeanHandler<Product>(Product.class),id);		
		return p;
	}

}
