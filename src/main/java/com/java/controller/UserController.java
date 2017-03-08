package com.java.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.util.ResponseUtil;

@Controller
@RequestMapping("/user")
@SuppressWarnings("deprecation")
public class UserController {

	@Resource
	protected UserService userService;

	// ��¼
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		System.out.println(user);
		User userList = userService.login(user);
		if (userList != null && userList.getType().equals("����Ա")) {
			System.out.println(user);
			userList.setStatus("����");
			userList.setLastLoginTime(new Date());
			userService.update(userList);
			request.getSession().setAttribute("userAdmin", userList);
			return "index";
		} else {
			request.setAttribute("errorInfo", "�û�������������󣡻�û��Ȩ��");
			return "login";
		}

	}

	// ���
	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		user.setStatus("����");
		user.setCreateTime(new Date());
		user.setLastLoginTime(null);
		User flag = userService.isExist(user);
		StringBuffer result = new StringBuffer();
		if (flag == null) {
			userService.add(user);
			result.append("<script language='javascript'>alert('��ӳɹ���');</script>");
		} else {
			result.append("<script language='javascript'>alert('���ʧ�ܣ���ӵĴ���');</script>");
		}
		ResponseUtil.write(response, result);
		return null;
	}

	// ��ʾ�����û�
	@RequestMapping("/showAll")
	public String showAll(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<User> userList = userService.showAll();
		request.setAttribute("userList", userList);
		return "forward:/jsp/showAll.jsp";
	}

	// ����idɾ��
	@RequestMapping("/deleteByNumber")
	public String deleteByNumber(
			@RequestParam(value = "number", required = false) int number,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = (User) request.getSession().getAttribute("userAdmin");
		User user2 = new User();
		user2.setNumber(number);
		User user3 = userService.isExist(user2);
		if (user.getNumber() != number && !user3.getStatus().equals("����")) {
			int flag = userService.deleteByNumber(number);
			request.setAttribute("errorInfo", "ɾ���ɹ�");
			return "forward:/user/showAll.do";
		} else {
			request.setAttribute("errorInfo", "����ɾ������¼��");
			return "forward:/user/showAll.do";
		}

	}

	// �޸��û���Ϣ
	@RequestMapping("/updateMessage")
	public String updateMessage(User user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer number = user.getNumber();
		User user2 = new User();
		user2.setNumber(number);
		User currentUser = userService.isExist(user2);
		user.setCreateTime(currentUser.getCreateTime());
		user.setLastLoginTime(currentUser.getLastLoginTime());
		int flag = userService.updateMessage(user);
		StringBuffer result = new StringBuffer();
		if (flag == 1) {
			result.append("<script language='javascript'>alert('�޸ĳɹ���');</script>");
		} else {
			result.append("<script language='javascript'>alert('�޸�ʧ�ܣ�');</script>");
		}
		ResponseUtil.write(response, result);
		return "redirect:/user/showAll.do";
	}

	// ���ҵ�����Ϣ
	@RequestMapping("/findByNumber")
	public String findByNumber(
			@RequestParam(value = "number", required = false) Integer number,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = new User();
		user.setNumber(number);
		User currentUser = userService.isExist(user);
		request.setAttribute("currentUser", currentUser);
		return "forward:/jsp/modifyUser.jsp";
	}
}
