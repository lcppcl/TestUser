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

	// 登录
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		User userList = userService.login(user);
		userList.setStatus("在线");
		userList.setLastLoginTime(new Date());
		System.out.println(user + "///////////////////");
		userService.update(userList);
		System.out.println(userList);
		return "index";
	}

	// 添加
	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		user.setStatus("离线");
		user.setLastLoginTime(new Date(0, 0, 0, 0, 0, 0));
		User flag = userService.isExist(user);
		StringBuffer result = new StringBuffer();
		if (flag == null) {
			userService.add(user);
			result.append("<script language='javascript'>alert('添加成功！');</script>");
		} else {
			result.append("<script language='javascript'>alert('添加失败！添加的存在');</script>");
		}
		ResponseUtil.write(response, result);
		return null;
	}

	// 显示所有用户
	@RequestMapping("/showAll")
	public String showAll(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<User> userList = userService.showAll();
		request.setAttribute("userList", userList);
		return "forward:/jsp/showAll.jsp";
	}

	// 根据id删除
	@RequestMapping("/deleteById")
	public String deleteById(
			@RequestParam(value = "id", required = false) int id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int flag = userService.deleteById(id);
		return "redirect:/user/showAll.do";
	}

	// 修改用户信息
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
			result.append("<script language='javascript'>alert('更新成功！');</script>");
		} else {
			result.append("<script language='javascript'>alert('更新失败！');</script>");
		}
		ResponseUtil.write(response, result);
		return "redirect:/user/showAll.do";
	}

	// 查找单个信息
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
