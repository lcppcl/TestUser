package com.java.dao;

import java.util.List;

import com.java.entity.User;

public interface UserDao {
	// �û���¼
	public User login(User user);

	// �û���¼����ʱ���״̬
	public void update(User user);

	// ����û�
	public int add(User user);

	// ���ʱ�ж��Ƿ����
	public User isExist(User user) throws Exception;
	
	//��ʾ�����û�
	public List<User> showAll();
	
	//����idɾ��
	public int deleteById(int id);
	
	//�����û�
	public int updateMessage(User user);
	
	
}
