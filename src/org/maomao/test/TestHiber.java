package org.maomao.test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.maomao.entity.Computer;
import org.maomao.utils.BaseDao;
import org.maomao.utils.DataWrapper;

public class TestHiber {
	public static void main(String[] args) {
		BaseDao baseDao = new BaseDao();
		
		Connection conn = baseDao.getConnection();
		String sql = "select * from tbl_computer";
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			List<Computer> list = DataWrapper.wrapData(rs, Computer.class);
			
			for (Computer computer : list) {
				System.out.println(computer.price);
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}



















