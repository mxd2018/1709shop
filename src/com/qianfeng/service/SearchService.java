package com.qianfeng.service;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.dao.SearchDao;
import com.qianfeng.domain.Product;

public class SearchService {

	public List<Product> findProductListBySearch(String info) throws SQLException {
		SearchDao dao = new SearchDao();
		List<Product> list = dao.findProductListBySearch(info);
		//System.out.println(list);
		return list;
	}

}
