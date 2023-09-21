package org.iclass.ex;

//스프링 컨테이너에 의해 관리되는 DAO(Data Access Object) 클래스
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Component
@Setter 
@Slf4j
public class ProductDao {
	
	private int count;
	
	//3) 기본생성자 정의
//	public ProductDao() {
//		System.out.println("::::: ProductDao 기본 생성자 :::::");
//	}
	
	//@Value 어노테이션을 사용하여 count 필드의 초기값을 설정.
	//이 값은 스프링 설정 파일에서 지정한 값으로 주입
	
	//생성자 주입과 setter 주입 두 가지 방법을 제공
	
	//파라미터 타입이 bean(객체) 이 아니므로 자동 주입과정이 없습니다. 	
	@Value("22")
//	public void setCount(@Value("22") int count) {	//파라미터에서 @Value 설정은 setter 동작 안합니다.
	public void setCount(int count) {	
	  System.out.println("---- ProductDao setter 메소드 ----"); 
	  this.count = count; 
	  }
	 	
	//@Value 를 여기로 옮기면 오류가 납니다.
	public ProductDao(@Value("10") int count) {
		log.info("::::: ProductDao 생성자 - int value 전달 :::");
		log.info("count 값 : {}", count);
		this.count=count;
	}
	
	//product 메소드는 count 값을 출력하는 간단한 메시지를 출력
	public void product() {
		System.out.println("---- ProductDao product() 메소드 ----");
		System.out.println("----- 수량 : " + count + " 생산합니다.");
	}
}
