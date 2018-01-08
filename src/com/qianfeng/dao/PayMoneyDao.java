package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.domain.buyProducts;
import com.qianfeng.domain.vo.Orderdetail;
import com.qianfeng.utils.C3P0Utils;

public class PayMoneyDao {

	public void addUid(String uid, String date_string, int pcount,double totalprice, String state, String oid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into o_u_relation values(?,?,?,?,?,?)";
		qr.update(sql,oid,date_string,pcount,totalprice,state,uid);
		
	}

	public void addPidandOid(String pid, String oid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into o_p_relation values(?,?)";
		qr.update(sql,oid,pid);
	}

	public List<buyProducts> getOrder_detail(String uid,String oid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql="SELECT uname,telephone,addr,addr2,pname,market_price,pimage,pdesc FROM "
				+ "shoppinguser ,o_u_relation,o_p_relation,product "
				+ "WHERE o_u_relation.uno=?  "
				+"AND shoppinguser.uid=?"
				+ "AND o_u_relation.oid=o_p_relation.oid "
				+ "AND o_p_relation.pid=product.pid "
				+ "AND o_u_relation.oid=?";
		List<buyProducts> list = qr.query(sql, new BeanListHandler<buyProducts>(buyProducts.class),uid,uid,oid);
		//System.out.println(list);
		return list;
	}

	

}
