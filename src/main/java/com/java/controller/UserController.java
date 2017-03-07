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
		User userList = userService.login(user);
		userList.setStatus("����");
		userList.setLastLoginTime(new Date());
		System.out.println(user + "///////////////////");
		userService.update(userList);
		System.out.println(userList);
		return "index";
	}

	// ���
	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		user.setStatus("����");
		user.setLastLoginTime(new Date(0, 0, 0, 0, 0, 0));
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
	@RequestMapping("/deleteById")
	public String deleteById(
			@RequestParam(value = "id", required = false) int id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int flag = userService.deleteById(id);
		return "redirect:/user/showAll.do";
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
			userService.add(user);
			result.append("<script language='javascript'>alert('���³ɹ���');</script>");
		} else {
			result.append("<script language='javascript'>alert('����ʧ�ܣ�');</script>");
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
		System.out.println(currentUser.toString());
		request.setAttribute("currentUser", currentUser);
		return "forward:/jsp/modifyUser.jsp";
	}
}
