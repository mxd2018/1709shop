package com.qianfeng.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.qianfeng.dao.OrderhistoryDao;
import com.qianfeng.dao.PayMoneyDao;
import com.qianfeng.domain.buyProducts;
import com.qianfeng.domain.vo.Order;
import com.qianfeng.domain.vo.Orderdetail;


public class PayMoneyService {

	public void payMoney(String pid) {
		// TODO Auto-generated method stub
		
		
	}

	public Order addUid(String uid,String oid,double totalprice) throws SQLException {
		// TODO Auto-generated method stub
		PayMoneyDao dao = new PayMoneyDao();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		String date_string = format.format(date);
		int pcount=1;
		String state="Î´Ö§¸¶";
		
		Order or=new Order();
		or.setOid(oid);
		or.setOrdertime(date_string);
		or.setPcount(pcount);
		or.setTotalprice(totalprice);
		or.setState(state);
		or.setUno(uid);
		
		dao.addUid(uid,date_string,pcount,totalprice,state,oid);
		
		return or;
	}

	public void addPidandOid(String pid, String oid) throws SQLException {
		// TODO Auto-generated method stub
		PayMoneyDao dao = new PayMoneyDao();
		dao.addPidandOid(pid, oid);
	}

	public  List<buyProducts> getOrder_detail(String uid, String oid) throws SQLException {
		PayMoneyDao dao = new PayMoneyDao();
		List<buyProducts> buypros= dao.getOrder_detail(uid,oid);
		//System.out.println(buypros);
		
		/*Orderdetail ord=new Orderdetail();
		ord.setBuypros(buypros);*/
	
		return buypros;
		 
	}

	public Order getOrder(String oid) throws SQLException {
		OrderhistoryDao dao =new OrderhistoryDao();
		Order o=dao.getOrder(oid);
		return o;
	}

}
