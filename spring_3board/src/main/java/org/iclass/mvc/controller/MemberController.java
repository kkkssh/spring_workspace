package org.iclass.mvc.controller;

import org.iclass.mvc.dto.BookUser;
import org.iclass.mvc.service.BookUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final BookUserService service;
	
	@GetMapping("/join")    
	public void joinView() {	//join.jsp View로 요청 전달
	}	

	@PostMapping("/save")
	public String join(BookUser dto,RedirectAttributes redirectAttributes) {
		service.join(dto);
		redirectAttributes.addFlashAttribute("message","회원가입이 완료되었습니다.");
	
	return "redirect:/login";
	}
}
