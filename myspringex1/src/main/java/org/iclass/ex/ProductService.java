package org.iclass.ex;

//스프링 컨테이너에 의해 관리되는 서비스 클래스
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
	
	private ProductDao dao;			
	
	//3) setter 주입을 위해서 기본생성자 정의
	public ProductService() {
		System.out.println("::::: ProductService 생성자 ::::");
	}

	//@Autowired 어노테이션을 사용하여 ProductDao 빈을 주입받는 방식으로 의존성 주입을 구현
	@Autowired
	public void setDao(ProductDao dao) {
		System.out.println("---- ProductService setter 메소드 ----");
		this.dao = dao;
	}
	
	//생성자 주입과 setter 주입 두 가지 방법을 제공
	//2)생성자 주입
	//@Autowired  //3)setter 주입할 때 주석처리
	public ProductService(ProductDao dao) {
		System.out.println("::::: ProductService 생성자 - ProductDao bean 주입 :::");
		this.dao=dao;
	}
	
	//product 메소드는 ProductDao의 product 메소드를 호출
	public void product() {
		System.out.println("---- ProductService product() 메소드 ----");
		dao.product();
	}
}
