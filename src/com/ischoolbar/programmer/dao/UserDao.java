package com.ischoolbar.programmer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ischoolbar.programmer.entity.User;

public class UserDao extends BaseDao<User> {
//	public boolean add(User user) {
//		String sql="insert into User(id,name,password,birthday) values(null,?,?,?)";
//		try {
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			preparedStatement.setString(1, user.getName());
//			preparedStatement.setString(2, user.getPassword());
//			preparedStatement.setDate(3, user.getDate());
//			return preparedStatement.executeUpdate()>0;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}

}
