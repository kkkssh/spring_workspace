package org.iclass.my;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SangheeController {
	
	private final SangheeService service;
		
	public int product() {
		System.out.println("＠＠ SangheeController product() 메소드 ＠＠");
		int result = service.product();
		System.out.println("＠＠ service result : " + result + " ＠＠");
		
		return result;
	}
}
