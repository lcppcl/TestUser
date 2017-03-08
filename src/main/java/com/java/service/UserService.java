package com.java.service;

import java.util.List;

import com.java.entity.User;

public interface UserService {
	// �û���¼
	public User login(User user);

	// �û���¼����ʱ���״̬
	public void update(User user);

	// ����û�
	public int add(User user);

	// ���ʱ�ж��Ƿ����
	public User isExist(User user) throws Exception;

	// ��ʾ�����û�
	public List<User> showAll();
	
	//����idɾ��
	public int deleteByNumber(int number);
	
	//�����û�
	public int updateMessage(User user);
}
