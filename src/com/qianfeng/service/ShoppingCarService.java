package com.qianfeng.service;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.dao.ShoppingCarDao;
import com.qianfeng.domain.Product;

public class ShoppingCarService {

	public Product showShoppingCarProduct(String pid) throws SQLException {
		// ��ù��ﳵ�е���Ʒ��Ϣ����װ��������
		ShoppingCarDao dao = new ShoppingCarDao();
		Product p=dao.showShoppingCarProduct(pid);
		return p;
	}

}
