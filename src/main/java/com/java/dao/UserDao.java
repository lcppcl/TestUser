package com.java.dao;

import java.util.List;

import com.java.entity.User;

public interface UserDao {
	// 用户登录
	public User login(User user);

	// 用户登录更新时间和状态
	public void update(User user);

	// 添加用户
	public int add(User user);

	// 添加时判断是否存在
	public User isExist(User user) throws Exception;
	
	//显示所有用户
	public List<User> showAll();
	
	//根据id删除
	public int deleteById(int id);
	
	//更新用户
	public int updateMessage(User user);
	
	
}
