package org.iclass.my;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
//@Setter 
//@RequiredArgsConstructor		//@Value 로 int 값을 초기화 하기 위해 직접 작성
public class SangheeDao {
	
	private final int count;

		
	public SangheeDao(@Value("31") int count) {	
		this.count=count;
	}
	
	public int product() {
		System.out.println("★★ SangheeDao product() 메소드 ★★");
		System.out.println("★★ 나이 : " + count + " 살 입니다. ★★");
		return this.count;
	}
}
