package com.kim.blog.dao;

import com.kim.blog.dto.BlogDto;

public interface IBlogDao {
	
	int save(String title,String content,int userId);
	BlogDto select(int id);
	void update();
	void delete(int boardId);
}
