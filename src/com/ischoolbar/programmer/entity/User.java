package com.ischoolbar.programmer.entity;

import java.sql.Date;

public class User extends BaseEntity  {
	private int id;
	private String name;
	private String password;
	private Date birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return birthday;
	}
	public void setDate(Date date) {
		this.birthday = date;
	}
	

}
