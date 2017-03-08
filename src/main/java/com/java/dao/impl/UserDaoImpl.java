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

	// �û���¼
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

	// �û���¼ʱ���ĵ�¼ʱ���״̬
	@Override
	public void update(User user) {
		String sql = "update t_user set status=:status,lastLoginTime=:lastLoginTime where name=:name and password=:password";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(sql, ps);
	}

	// ���
	@Override
	public int add(User user) {
		String sql = "insert into t_user value(null,:number,:name,:password,:remark,:status,:createTime,:lastLoginTime,:type)";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		return namedParameterJdbcTemplate.update(sql, ps);
	}

	// ����ʱ�ж��Ƿ����
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

	// ��ʾ����
	@Override
	public List<User> showAll() {
		String sql = "select * from t_user";
		List<User> userList = namedParameterJdbcTemplate.getJdbcOperations()
				.query(sql, new BeanPropertyRowMapper(User.class));
		return userList;
	}

	// ����idɾ��
	@Override
	public int deleteByNumber(int number) {
		String sql = "delete from t_user where number=:number";
		Map map = new HashMap();
		map.put("number", number);
		return namedParameterJdbcTemplate.update(sql, map);
	}

	// �����û���ϸ��Ϣ
	@Override
	public int updateMessage(User user) {
		String sql = "update t_user set name=:name,password=:password,remark=:remark,type=:type where id=:id";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		return namedParameterJdbcTemplate.update(sql, ps);
	}

}
