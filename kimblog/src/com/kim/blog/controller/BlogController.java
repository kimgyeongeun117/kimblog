package com.kim.blog.controller;

import com.kim.blog.service.BlogService;

public class BlogController {

	private BlogService blogService;

	public BlogController() {
		blogService = new BlogService();
	}

	// 블로그 글 쓰기 요청
	public int reqSaveBoard(String title, String content, int userId) {
		if (userId != 0) {
			return blogService.saveBoard(title, content, userId);
		}

		return 0;
	}

	// 게시글 삭제 요청
	public void requestBoardDelete(int boardId, int userId) {

		blogService.deleteByBoardId(boardId, userId);
	}
}
