package com.ischoolbar.programmer.dao;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ischoolbar.programmer.entity.BaseEntity;
import com.ischoolbar.programmer.util.DBUtil;
import com.ischoolbar.programmer.util.StringUtil;


public class BaseDao<T> {
	private DBUtil dbUtil=new DBUtil();
    Connection connection=dbUtil.getConnection();
    private final static int CURD_ADD=0;
	public void closeConnection() {
		dbUtil.closeConnection();
	}
	public boolean add(T t) {
		String sql=buildSql(t, CURD_ADD);
		System.out.println(sql);
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement=setPrepareStament(preparedStatement, t, CURD_ADD);
			return preparedStatement.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	/*
	 * 给SQL语句赋予值
	 */
	private PreparedStatement setPrepareStament(PreparedStatement preparedStatement,T t,int curdtype){
		Field[] fields=t.getClass().getDeclaredFields();
		switch(curdtype) {
		case CURD_ADD:
			for(int i=1;i<fields.length;i++) {
				try {
					fields[i].setAccessible(true);
					preparedStatement.setObject(i, fields[i].get(t));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			break;
		}
		
		// TODO Auto-generated method stub
		return preparedStatement;
	}
	private String buildSql(T t,int curdType) {
		String sql="";
		switch(curdType) {
		case CURD_ADD:
			sql="insert into "+getTableName(t)+"("+getAddTableFields(t)+ ") "+"values("+getAddTableValues(t)+")";
			break;
		}
		return sql;
		
		
	}
	private String getAddTableValues(T t) {
		// TODO Auto-generated method stub
		List<String> fields=getTableFields(t);
		String[] value=new String[fields.size()];
		Arrays.fill(value, "?");
		value[0]="null";
		
		return StringUtil.join(Arrays.asList(value),",");
	}
	private String getAddTableFields(T t) {
		// TODO Auto-generated method stub
		List<String> fieldsList=getTableFields(t);
		
		return StringUtil.join(fieldsList, ",");
	}
	/*
	 * 获取数据库的全部字段，通过反射获取相应的属性
	 */
	private List<String> getTableFields(T t) {
		// TODO Auto-generated method stub
		List<String> retList=new ArrayList<String>();
		Field[] declaredFields=t.getClass().getDeclaredFields();
		for(Field field: declaredFields) {
			retList.add(StringUtil.convertToundercase(field.getName()));
			}
		if(BaseEntity.class.isAssignableFrom(t.getClass())) {
			//说明继承自BaseEntity类
			
		}
		return retList;
	}
	
	/*
	 * 获取数据库的表名
	 */
	private String getTableName(T t) {
		// TODO Auto-generated method stub
		return StringUtil.convertToundercase(t.getClass().getSimpleName());
	}

}
