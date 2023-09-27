package org.iclass.mvc.service;

import java.util.Map;

import org.iclass.mvc.dao.BookuserMapper;
import org.iclass.mvc.dto.BookUser;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)		//생성자 접근권한
public class BookUserService {

	private final BookuserMapper dao;
	
	//로그인
	public BookUser login(Map<String,String> map){
		return dao.login(map);
	}
	//회원가입
	public int join(BookUser dto) {
		return dao.join(dto);
	}
	
}
