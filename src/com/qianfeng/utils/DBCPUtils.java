package com.qianfeng.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource pool = null;
	static {
		// DBCP需要手动的附一个Properties对象
		InputStream is = Thread.currentThread().
		getContextClassLoader().getResourceAsStream("dbinfo.properties");
		Properties p = new Properties();
		try {
			p.load(is);
			// 通过DBCP连接池工厂获得一个与p对象关联的连接池对象。
			pool = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得一个Connection对象
	public static Connection getConnection() throws Exception {
		return pool.getConnection();
	}
	//获得连接池对象
	public static DataSource getDataSource() {
		return pool;
	}
}
