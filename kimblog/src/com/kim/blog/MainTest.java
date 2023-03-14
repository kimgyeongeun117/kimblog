package com.kim.blog;

import com.kim.blog.controller.BlogController;
import com.kim.blog.controller.UserController;
import com.kim.blog.dto.UserDto;

public class MainTest {

	public static void main(String[] args) {
		UserDto userDTO = new UserDto("이원우", "1239", "wonwoo@naver.com", "부산");
		UserController userController = new UserController();
		BlogController blogController = new BlogController();

		// 사용자 회원 가입
		String result = userController.requestSignUp(userDTO, "localhost");
		if (result == null) {
			System.out.println("회원가입 실패 ");
		} else {
			System.out.println("회원가입 성공");
		}

//		// 사용자 로그인 시도
//		UserDto responseUser = userController.requestSignIn(userDTO.getUserName(), userDTO.getPassword());
//		if (responseUser == null) {
//			System.out.println("로그인 실패");
//		} else {
//			System.out.println("로그인 성공");
//		}
//
//		// 블로그 글쓰기
//		blogController.reqSaveBoard("능력 단위 평가", "서버 프로그램 구현", responseUser.getId());
//
//		// 블로그 글삭제
//		blogController.requestBoardDelete(1, responseUser.getId());

	}

}
