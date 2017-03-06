package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.dao.impl.UserDaoImpl;
import com.java.entity.User;
import com.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

	@Override
	public User isExist(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.isExist(user);
	}

	@Override
	public List<User> showAll() {
		// TODO Auto-generated method stub
		return userDao.showAll();
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteById(id);
	}

	@Override
	public int updateMessage(User user) {
		// TODO Auto-generated method stub
		return userDao.updateMessage(user);
	}

}
