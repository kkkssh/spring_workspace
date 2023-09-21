package org.iclass.ex;

//스프링 컨테이너에 의해 관리되는 컨트롤러 클래스
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductController {
	
	private ProductService service;
	
	//3) setter 주입을 위해서 기본생성자 정의
	public ProductController() {
		System.out.println("::::: ProductController 기본 생성자 :::::");
	}
	
	//@Autowired 어노테이션을 사용하여 ProductService 빈을 주입받는 방식으로 의존성 주입을 구현
	@Autowired
	public void setService(ProductService service) {   
		//파라미터 의존관계 - 타입이 bean 이면 @Autowired(자동주입-ProductService type 일치하는 bean 선택)
		System.out.println("---- ProductController setter 메소드 ----");
		this.service = service;
	}
	
	//생성자 주입과 setter 주입 두 가지 방법을 제공
	//2)생성자 주입
	//	@Autowired   //3)setter 주입할 때 주석처리
	public ProductController(ProductService service) {
		System.out.println("::::: ProductController 생성자 - ProductService bean 주입 :::");
		this.service=service;
	}
	
	//product 메소드는 ProductService의 product 메소드를 호출
	public void product() {
		System.out.println("---- ProductController product() 메소드 ----");
		service.product();
	}
}
