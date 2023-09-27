package org.iclass.mvc.controller;

import java.time.LocalDate;

import org.iclass.mvc.dto.Community;
import org.iclass.mvc.dto.CommunityComments;
import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/community")
@Slf4j
public class CommunityController {

	private final CommunityService service;
	
	private CommunityController(CommunityService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public void list(@RequestParam(defaultValue =  "1") 	//파라미터 값이 없으면 오류. 기본값 설정
			int page, Model model) {	//메소드 인자 int page 는 url 의 파라미터
		//Model : view 로 전달될 데이터를 주로 저장하는 역할
		//addAttribute 메소드 : request.setAttribute 와 동일.(session 도 Model 사용 가능. 로그인에서 사용)
		model.addAttribute("list",service.pagelist(page).get("list"));
		model.addAttribute("paging",service.pagelist(page).get("paging"));
		model.addAttribute("today",LocalDate.now());
		
	}
	
	@GetMapping("/read")
	public void read(long idx, 
			@ModelAttribute("page")		//파라미터로 받을 값을 Model 객체 - model.addAttribute 와 같이 저장합니다.
			int page, Model model) {
		model.addAttribute("vo", service.read(idx));
		model.addAttribute("cmtlist",service.commentsList(idx));
	}
	
	@GetMapping("/write")
	public void write() {
		//글쓰기 GET 요청은 view name 만 지정하고 끝.
	}
	@PostMapping("/write")
	public String save(Community dto
			,RedirectAttributes redirectAttributes) {	//파라미터가 많을 때, 그것들을 필드로 갖는 dto 또는 map 타입으로 전달받기
		log.info("INSERT dto : {}",dto);
		service.insert(dto);
		
		//addFlashAttribute 는 URL 에 노출이 안되고 말 그대로 1회성
		redirectAttributes.addFlashAttribute("message","글 등록이 완료되었습니다");
		return "redirect:/community/list";
	}
	//location.href='list.jsp' 는 자바스크립트 - 클라이언트 브라우저에서 주소 변경
	//response.sendRedirect("list.jsp") 는 서버에서 클라이언트가 새로 보낼 요청을 강제로 실행.
	//			ㄴ POST 요청을 처리한 후에는 redirect 를 합니다.
	/*
	 * @GetMapping("/update") public void update(long idx, @ModelAttribute("page")
	 * int page, Model model) { model.addAttribute("vo", service.selectByIdx(idx));
	 * }
	 */
	
	/*
	 * @PostMapping("/update") public String updateSave(Community
	 * vo,@ModelAttribute("page") int page, @ModelAttribute("idx") long idx) {
	 * log.info("UPDATE dto : {}",vo); service.update(vo);
	 * 
	 * return "redirect:/community/list"; }
	 */
	
	@PostMapping("/update")
	public void update(long idx,@ModelAttribute("page") int page, Model model) {
		model.addAttribute("vo",service.selectByIdx(idx));
		//int page 는 @ModelAttribute 로 model.addAttribute("page",page); 를 대신해서 update.jsp 로 전달
	}
	
	@PostMapping("/save")
	public String updateProc(int page, Community vo,
//			▼ RedirectAttributes 대신에 Model 로 사용해도 사용 가능 ▼
//			Model model) {
			RedirectAttributes redirectAttributes) {
		service.update(vo);
		
		redirectAttributes.addAttribute("idx",vo.getIdx());
		redirectAttributes.addAttribute("page",page);
//		model.addAttribute("idx",vo.getIdx());
//		model.addAttribute("page",page);
		redirectAttributes.addFlashAttribute("message","글 수정이 완료되었습니다");
		
//		return "redirect:/community/list?page="+page;
//		수정 후 다시 글상세보기
		return "redirect:/community/read";
	}
	
	
	
	@PostMapping("/delete")
	public String delete(@ModelAttribute("page") int page, long idx,
//@ModelAttribute("page") 랑 RedirectAttributes 를 동시에 사용하면 충돌생겨서 동작이 정상적으로 안됨
			RedirectAttributes redirectAttributes) {
		service.delete(idx);
		
		redirectAttributes.addAttribute("page",page);
		redirectAttributes.addFlashAttribute("message","글 삭제가 완료되었습니다");
		//@ModelAttribute 와 RedirectAttributes 충돌하므로 직접 코딩함.
		return "redirect:/community/list";
	}
	
	@PostMapping("/comments")
	public String comments(int page, int f, CommunityComments dto,
			RedirectAttributes redirectAttributes) {
		log.info(">>>>>>>>>>>>>>>>>>>>>> dto : {}",dto);
		service.comments(dto,f);
		redirectAttributes.addAttribute("page",page);
		redirectAttributes.addAttribute("idx", dto.getMref());
		
		String message = null;
		if(f==1)message = "댓글 등록 하였습니다.";
		else if(f==2)message = "댓글 삭제 하였습니다.";
		redirectAttributes.addFlashAttribute("message",message);
		
//		return "redirect:/community/read?page="+page+"&idx="+dto.getMref();
		return "redirect:/community/read";				//RedirectAttributes 사용하므로 쿼리스트링 안씀
	}
	
}





