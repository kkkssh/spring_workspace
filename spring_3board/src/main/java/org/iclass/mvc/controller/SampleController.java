package org.iclass.mvc.controller;

import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// url 이 community 로 시작하면 DispatcherServlet 으로부터 CommunityController 가 위임 받아 처리한다.
@Controller
@RequestMapping("/sample")	
public class SampleController {
	
	private final CommunityService service;
	
	private SampleController(CommunityService service) {
		this.service = service;
	}
	
	//여기서부터는 요청을 처리하는 핸들러 메소드이다.
	//URL 설계 : 글 목록 조회 URL 은 /community/list , 글쓰기 /community/write , 글 읽기 /community/read
	@GetMapping("/list")
	public void list() {
		
	}
	@GetMapping("/write")
	public void write() {
		
	}
	@GetMapping("/read")
	public void read() {
		
	}
}
