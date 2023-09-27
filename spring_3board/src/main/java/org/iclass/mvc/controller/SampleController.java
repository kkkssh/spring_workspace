package org.iclass.mvc.controller;

import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")	//url 이 DispatcherServlet 으로부터 community 로 시작하면 CommunityController 가 위임받아 처리합니다.
public class SampleController {

	private final CommunityService service;
	
	private SampleController(CommunityService service) {
		this.service = service;
	}
	
	//요청을 처리하는 핸들러 메소드
	//URL 설계 : 글 목록 조회 ▶ /community/list , 글쓰기 ▶ /community/write , 글읽기 ▶ /community/read
	
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
