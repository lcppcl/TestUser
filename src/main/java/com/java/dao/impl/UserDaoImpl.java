package com.java.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.java.dao.UserDao;
import com.java.entity.User;

@Repository("userDao")
@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class UserDaoImpl implements UserDao {

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	// 用户登录
	@Override
	public User login(User user) {
		String sql = "select * from t_user where number=:number and password=:password";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		try {
			return (User) namedParameterJdbcTemplate.queryForObject(sql, ps,
					new BeanPropertyRowMapper(User.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	// 用户登录时更改登录时间和状态
	@Override
	public void update(User user) {
		String sql = "update t_user set status=:status,lastLoginTime=:lastLoginTime where name=:name and password=:password";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(sql, ps);
	}

	// 添加
	@Override
	public int add(User user) {
		String sql = "insert into t_user value(null,:number,:name,:password,:remark,:status,:createTime,:lastLoginTime,:type)";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		return namedParameterJdbcTemplate.update(sql, ps);
	}

	// 插入时判断是否存在
	@Override
	public User isExist(User user) {
		String sql = "select * from t_user where number=:number";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		try {
			return (User) namedParameterJdbcTemplate.queryForObject(sql, ps,
					new BeanPropertyRowMapper(User.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	// 显示所有
	@Override
	public List<User> showAll() {
		String sql = "select * from t_user";
		List<User> userList = namedParameterJdbcTemplate.getJdbcOperations()
				.query(sql, new BeanPropertyRowMapper(User.class));
		return userList;
	}

	// 根据id删除
	@Override
	public int deleteByNumber(int number) {
		String sql = "delete from t_user where number=:number";
		Map map = new HashMap();
		map.put("number", number);
		return namedParameterJdbcTemplate.update(sql, map);
	}

	// 更新用户详细信息
	@Override
	public int updateMessage(User user) {
		String sql = "update t_user set name=:name,password=:password,remark=:remark,type=:type where id=:id";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		return namedParameterJdbcTemplate.update(sql, ps);
	}

}
