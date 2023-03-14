package com.kim.blog.service;

import com.kim.blog.dao.BlogDao;
import com.kim.blog.dto.BlogDto;

public class BlogService {
	
	BlogDao blogDAO;

	public BlogService() {
		blogDAO = new BlogDao();
	}

	public int saveBoard(String title, String content, int userId) {
		int resultRowCount = 0;

		if (title.equals("") || title.length() < 2) {
			return resultRowCount;
		}
		
		resultRowCount = blogDAO.save(title, content, userId);
		return resultRowCount;
	}

	public void deleteByBoardId(int boardId,int userId) {
		BlogDto blogDTO = selectByBoardId(boardId);
		
		if(userId == blogDTO.getUserId()) {
			blogDAO.delete(boardId);
		}
	}
	
	public BlogDto selectByBoardId(int boardId) {
		BlogDto resultDto = blogDAO.select(boardId);
		
		return resultDto;
	}
}
