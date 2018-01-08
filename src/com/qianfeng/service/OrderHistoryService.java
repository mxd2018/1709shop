package com.qianfeng.service;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.dao.OrderhistoryDao;
import com.qianfeng.domain.vo.Order;

public class OrderHistoryService {

	public List<Order> findOrders(String uid) throws SQLException {
		OrderhistoryDao dao = new OrderhistoryDao();
		List<Order> orderhistory=dao.findOrders(uid);
		return orderhistory;
	}

}
