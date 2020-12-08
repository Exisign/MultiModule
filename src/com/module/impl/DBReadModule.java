package com.module.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.module.ReadModule;

public class DBReadModule implements ReadModule{

	private String driver = "";
	private String url = "";
	private String id = "";
	private String password = "";
	
	private Connection conn = null;
	//아래의 Queue는 추후, 적재와 읽기를 동시에 진행할 때를 대비해서 준비한다.
	private Queue<List<String>> queue = new ConcurrentLinkedQueue<List<String>>();
	
	public DBReadModule(Properties properties) throws Exception{
		readProperty(properties);
	}
	
	@Override
	public void readProperty(Properties properties) throws Exception {
		
		boolean isSuccess = false;
		
		try {
			driver 		= properties.getProperty("db.driver");
			url			= properties.getProperty("db.url");
			id			= properties.getProperty("db.id");
			password	= properties.getProperty("db.password");
			isSuccess		= true;
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Queue<List<String>> readData(Class enumClass) throws Exception {
		
		queue = new LinkedBlockingQueue<List<String>>();
		
		if(enumClass!=null&&enumClass.isEnum()) {
			
//			System.out.println(driver);
//			
			Class.forName(driver);	
			DriverManager.getDriver(url);
			conn = DriverManager.getConnection(url, id, password);
			
			PreparedStatement psmt = null;
			ResultSet rs = null;
			String query = "select * from ir_user_dic";
			
			psmt = conn.prepareStatement(query);
			
			try {
				rs = psmt.executeQuery();
				ResultSetMetaData rsd = rs.getMetaData();
				
				System.out.println("column count " + rsd.getColumnCount());
				int c = 0;
				
				while(rs.next()) {
					
					Object[] arrEnum = enumClass.getEnumConstants();
					List<String> row = new ArrayList<String>();
					for(int i = 0; i < arrEnum.length; i++) {
						row.add(rs.getString(i+1));
					}
					
					if(row.size()>0) {
						queue.add(row);
					}
				}
			}catch(Exception e) {
				System.out.println(e.getMessage() + e);
				e.printStackTrace();
			}finally {
				if(rs!=null) {
					try {
						rs.close();
					}catch(Exception e) {}
				}
				
				if(psmt!=null) {
					try {
						psmt.close();
					}catch(Exception e) {}
				}
				
				if(conn!=null) {
					try{
						conn.close();
					}catch(Exception e) {}
				}
			}
			
			return queue;
		}else {
			Exception e = new Exception("Class is not Enum.");
			throw e;
		}
	}
	
	
}
