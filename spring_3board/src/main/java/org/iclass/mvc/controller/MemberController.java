package org.iclass.mvc.controller;

import org.iclass.mvc.dto.BookUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {			//회원가입 구현해보기
	
	@RequestMapping("/test")
	public void test(@SessionAttribute("user") BookUser user) {		//로그인 방법1로 되롤려놓고 테스트 하기
		//LoginController 에서 저장된 user 세션 애트리뷰트를 가져온다.
		log.info("user test : {}", user);
	}
	
	@GetMapping("/save")
	public void save() {
		
	}
	
	@PostMapping("/save")
	public String saveProc(Model model)
	

}
