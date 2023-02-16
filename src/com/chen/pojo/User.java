package com.chen.pojo;

public class User {
	private String idNumber;
	private String name;
	private String password;
	private Integer authority;
	private Integer isDelete;

	public User() {
	}

	public User(String idNumber, String name, String password, Integer authority, Integer isDelete) {
		this.idNumber = idNumber;
		this.name = name;
		this.password = password;
		this.authority = authority;
		this.isDelete = isDelete;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "User{" +
				"idNumber='" + idNumber + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", authority=" + authority +
				", isDelete=" + isDelete +
				'}';
	}
}
