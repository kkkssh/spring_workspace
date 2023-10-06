package org.iclass.dto;

import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class PageRequestDTO {
	
	@Builder.Default	//builder로 객체 생성할 때 기본값을 1로 하겠다.
	@Min(value = 1)
	private int page =1;
	
	@Builder.Default 	//builder로 객체 생성할 때 기본값을 5로 하곘다.
	@Min(value = 5) @Max(value = 100)
	private int size=5;      //size 는 한 개 페이지 글 갯수
	
	public int getSkip() {
		return (page-1)*10;
		
	}
	
	private int start;
	private int end;

	public static PageRequestDTO of(int page,int size) {  
		
		int startNo=(page-1)* size+1;    //글목록 시작행번호(rownum)
		int endNo = startNo + (size-1);
		
		
		return PageRequestDTO.builder()
				.page(page)
				.size(size)
				.start(startNo)
				.end(endNo)
				.build();
	}
	
	
	//페이지 이동 파라미터
	private String link;
	
	public String getLink() {
		if(link==null) {
			StringBuilder builder = new StringBuilder();
			builder.append("page="+this.page);
			builder.append("&size="+this.size);
			link=builder.toString();
		}
		return link;
	}
	
	private String[] types;
	private String keyword;
	private boolean finished;
	private LocalDate from;
	private LocalDate to;
	
	public boolean checkType(String type){
		if(types == null || types.length==0) 
				return false;
		return Arrays.stream(types)
				.anyMatch(type::equals);
		//types에 저장된 배열을 스트림으로 변환하고 그 스트림과 인자로 전달된 type 값이 일치하는 것이 있으면 참.
		//검색 조건에 따라  화면에 표시를 해주기 위한 메소드이며 list.jsp에서 사용합니다.
	}

}
