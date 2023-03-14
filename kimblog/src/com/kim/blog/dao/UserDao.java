package com.kim.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kim.blog.dto.UserDto;
import com.kim.blog.utils.DBHelper;

public class UserDao implements IUserDao {
	
private DBHelper dbHelper;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDao() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}
	
	@Override
	public int saveUser(UserDto user) {
		int resultRow = 0;
		
		if(selectUserByUsernameAndPassword(user.getUserName(), user.getPassword()) != null) {
			return resultRow; 
		}
		
		String query = " INSERT INTO user(username,password,email,address,userRole,createDate) "
				+ " values(?,?,?,?,?,now()); ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUserRole());
			
			resultRow =  pstmt.executeUpdate();	// insert,update,delete 시 사용
		} catch (Exception e) {
			System.out.println(">> saveUser 함수에서 오류가 발생했어 <<");
			e.printStackTrace();
		} 
		
		return resultRow;
	}
	
	@Override
	public UserDto selectUserByUsernameAndPassword(String username,String password) {
		UserDto resultUser = null;
		
		String query = " SELECT * "
				+ "FROM user "
				+ "WHERE username = ? "
				+ "	AND password = ?; ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				UserDto dto = new UserDto();
				dto.setId(rs.getInt("id"));
				dto.setUserName(rs.getString("username"));
				dto.setEmail(rs.getString("email"));
				resultUser = dto;
			}
			
		} catch (Exception e) {
			System.out.println(">> userDAO 회원찾기 시 에러 발생 <<");
			e.printStackTrace();
		}
		
		return resultUser;
	}
}
