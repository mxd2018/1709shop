package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.domain.ValueBean;
import com.qianfeng.utils.C3P0Utils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ProductListDao {

	public List<Product> findAllProduct() throws SQLException {
		// 从数据库中查询出所有商品，返回pList集合
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product";
		List<Product> pList =null;
		pList = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return pList;
	}

	public void deleteProduct(String pid) throws SQLException {
		QueryRunner qr2= new QueryRunner(C3P0Utils.getDataSource());
		String sql="delete from product where pid=?";
		qr2.update(sql,pid);
		
	}

	public List<Category> showCategoryProduct() throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from category";
		List<Category> cList = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return cList;
	}

	public void addProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql,p.getPid(),p.getPname(),p.getMarket_price(),
				p.getShop_price(),p.getPimage(),p.getPdate(),p.getIs_hot(),
				p.getPdesc(),p.getPflag(),p.getCid());
	
	}

	public Product editProduct(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid=?";
		Product pro = qr.query(sql , new BeanHandler<Product>(Product.class),pid);
		return pro;
	}

	public void updateProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,"
				+ "pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		qr.update(sql,p.getPname(),p.getMarket_price(),
				p.getShop_price(),p.getPimage(),p.getPdate(),p.getIs_hot(),
				p.getPdesc(),p.getPflag(),p.getCid(),p.getPid());
		
	}

	public List<Product> searchProduct(ValueBean v) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product where 1=1";
		List<String> params= new ArrayList<>();
		
		if(v.getPname()!=null&&!"".equals(v.getPname().trim())){
			sql+=" and pname like ? ";
			params.add("%"+v.getPname().trim()+"%");
		}
		if(v.getIs_hot()!=null&&!"".equals(v.getIs_hot())){
			sql+=" and is_hot=? ";
			params.add(v.getIs_hot().trim());
		}
		if(v.getCid()!=null&&!"".equals(v.getCid())){
			sql+=" and cid=?";
			params.add(v.getCid().trim());
		}
		List<Product> pList = qr.query(sql, new BeanListHandler<Product>(Product.class),params.toArray());
		System.out.println(pList);
		return pList;
	}

	public List<Product> findProductByPageBean(int productIndex, int currentPageCount) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product limit ?,?";
		List<Product> product = qr.query(sql , new BeanListHandler<Product>(Product.class),productIndex,currentPageCount);
		
		return product;
	}

	public Long findProductTotalCount() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from product";
		Long totalCountLong = (Long) qr.query(sql,new ScalarHandler());
		return totalCountLong;
	}

	public Product findProduct(String pid) throws SQLException {
		QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from product where id=?";
		Product p = qr.query(sql, new BeanHandler<Product>(Product.class),pid);
		return p;
	}

}
