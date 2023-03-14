package com.kim.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kim.blog.dto.BlogDto;
import com.kim.blog.utils.DBHelper;

public class BlogDao implements IBlogDao{
	
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BlogDao() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	@Override
	public int save(String title,String content,int userId) {
		int resultRowCount = 0;
		String query = " INSERT INTO board(title,content,userId) "
				+ "values(?,?,?); ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, userId);
			resultRowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(">> blogDAO save에서 에러 발생 <<");
			e.printStackTrace();
		}
		
		return resultRowCount;
	}

	@Override
	public BlogDto select(int id) {
		BlogDto blogDto = null;
		String query = " SELECT * " + "FROM board " + "where id = ?; ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				blogDto = new BlogDto();
				
				blogDto.setId(rs.getInt("id"));
				blogDto.setTitle(rs.getString("title"));
				blogDto.setContent(rs.getString("content"));
				blogDto.setReadCount(rs.getInt("readCount"));
				blogDto.setUserId(rs.getInt("userId"));
			}

		} catch (SQLException e) {
			System.out.println(">> BlogDao select(int id) 에러 발생 <<");
			e.printStackTrace();
		}
		
		return blogDto;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void delete(int boardId) {
		String query = " DELETE from board where id = ?; ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,boardId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(">> blogDao delete 에러 발생 <<");
			e.printStackTrace();
		}
		
	}
}
