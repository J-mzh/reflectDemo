package org.maomao.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.maomao.entity.Computer;

public class DataWrapper {
	public static List wrapData(ResultSet rs, Class clazz){
		List list = new ArrayList();
		try {
			while(rs.next()){
				Object entity = clazz.newInstance();
				//1.获取查询返回的列明
				ResultSetMetaData metaData = rs.getMetaData();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					String columnName = metaData.getColumnName(i);
					Object columnValue = rs.getObject(columnName);
					
					//给属性赋值
					try {
						Field f =  clazz.getDeclaredField(columnName);
						f.setAccessible(true);
						f.set(entity, columnValue);
					} catch (Exception e) {
						e.printStackTrace();
					} 
					
				}
				list.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
	}
}
