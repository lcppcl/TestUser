package com.java.entity;

import java.util.Date;

public class User {
	private int id;
	private Integer number;// 用户编码
	private String name;// 名称
	private String password;// 密码
	private String remark;// 备注
	private String status;// 状态
	private Date createTime;// 创建时间
	private Date lastLoginTime;// 最后登录时间
	private String type;// 帐号类型

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", number=" + number + ", name=" + name
				+ ", password=" + password + ", remark=" + remark + ", status="
				+ status + ", createTime=" + createTime + ", lastLoginTime="
				+ lastLoginTime + ", type=" + type + "]";
	}

	

}
