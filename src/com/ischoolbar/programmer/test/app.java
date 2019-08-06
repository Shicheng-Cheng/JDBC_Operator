package com.ischoolbar.programmer.test;

import java.sql.Date;

import com.ischoolbar.programmer.dao.UserDao;
import com.ischoolbar.programmer.entity.User;

public class app {
	private int id;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName("NBAa");
		user.setPassword("123");
		user.setDate(new Date(System.currentTimeMillis()));
		UserDao userDao=new UserDao();
		System.out.println(userDao.add(user));
		userDao.closeConnection();
	

	}

}
