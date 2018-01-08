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
		// DBCP��Ҫ�ֶ��ĸ�һ��Properties����
		InputStream is = Thread.currentThread().
		getContextClassLoader().getResourceAsStream("dbinfo.properties");
		Properties p = new Properties();
		try {
			p.load(is);
			// ͨ��DBCP���ӳع������һ����p������������ӳض���
			pool = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���һ��Connection����
	public static Connection getConnection() throws Exception {
		return pool.getConnection();
	}
	//������ӳض���
	public static DataSource getDataSource() {
		return pool;
	}
}
