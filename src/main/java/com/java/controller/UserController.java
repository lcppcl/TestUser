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
		System.out.println(user);
		User userList = userService.login(user);
		if (userList != null && userList.getType().equals("管理员")) {
			System.out.println(user);
			userList.setStatus("在线");
			userList.setLastLoginTime(new Date());
			userService.update(userList);
			request.getSession().setAttribute("userAdmin", userList);
			return "index";
		} else {
			request.setAttribute("errorInfo", "用户名或者密码错误！或没有权限");
			return "login";
		}

	}

	// 添加
	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		user.setStatus("离线");
		user.setCreateTime(new Date());
		user.setLastLoginTime(null);
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
	@RequestMapping("/deleteByNumber")
	public String deleteByNumber(
			@RequestParam(value = "number", required = false) int number,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = (User) request.getSession().getAttribute("userAdmin");
		User user2 = new User();
		user2.setNumber(number);
		User user3 = userService.isExist(user2);
		if (user.getNumber() != number && !user3.getStatus().equals("在线")) {
			int flag = userService.deleteByNumber(number);
			request.setAttribute("errorInfo", "删除成功");
			return "forward:/user/showAll.do";
		} else {
			request.setAttribute("errorInfo", "不能删除，登录中");
			return "forward:/user/showAll.do";
		}

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
			result.append("<script language='javascript'>alert('修改成功！');</script>");
		} else {
			result.append("<script language='javascript'>alert('修改失败！');</script>");
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
		request.setAttribute("currentUser", currentUser);
		return "forward:/jsp/modifyUser.jsp";
	}
}
