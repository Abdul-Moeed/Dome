package com.hibernate.dao;

import java.util.List;

import com.hibernate.util.users;

public interface userdao{
	public List<users> getuser(int key);
	public List<users> getuser(String email);
	public List<users> getusernum(String phone_number);
	public void save(users user);
}
