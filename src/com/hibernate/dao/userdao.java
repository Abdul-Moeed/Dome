package com.hibernate.dao;

import java.util.List;

import com.hibernate.util.users;

public interface userdao {
	public List<users> getuser(int key, String pass);
}
