package com.kim.blog.dto;

public class UserDto {
	
	private int id;
	private String userName;
	private String password;
	private String email;
	private String address;
	private String userRole;
	private String createDate;
	
	public UserDto() {
		
	}
	
	public UserDto(String userName, String password, String email, String address) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", userRole=" + userRole + ", createDate=" + createDate + "]";
	}
}
