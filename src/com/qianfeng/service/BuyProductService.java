package com.qianfeng.service;

import java.sql.SQLException;

import com.qianfeng.dao.BuyProductDao;
import com.qianfeng.domain.Product;

public class BuyProductService {

	public Product buyProduct(String pid) throws SQLException {
		//����id���»�ȡҪ�������Ʒ����Ϣ
		BuyProductDao dao=new BuyProductDao();
		Product pro=dao.buyProduct(pid);
		return pro;
	}

}
