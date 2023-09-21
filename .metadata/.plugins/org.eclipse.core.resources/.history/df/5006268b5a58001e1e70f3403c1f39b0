package org.iclass.my;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
@Setter 
public class SangheeDao {
	
	private int count;
	@Value("22")
	public void setCount(int count) {
		 System.out.println("---- ProductDao setter 메소드 ----"); 
		 this.count = count; 
		 }
	
	//3) 기본생성자 정의
//	public SangheeDao() {
//		System.out.println("::::: SangheeDao 기본 생성자 :::::");
//	}
		
	public SangheeDao(@Value("31") int count) {
		System.out.println("::::: SangheeDao 생성자 - int value 전달 :::");
		this.count=count;
	}
	
	public int product() {
		System.out.println("★★ SangheeDao product() 메소드 ★★");
		System.out.println("★★ 나이 : " + count + " 살 입니다. ★★");
		return this.count;
	}
}
