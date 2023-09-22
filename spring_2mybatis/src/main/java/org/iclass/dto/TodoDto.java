package org.iclass.dto;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {
	private long tno;
	private String title;				//제목
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;			//할일 기한 날짜. mybatis 에서 날짜 타입을 Date 가 아닌
//	private Date dueDate;				//					ㄴ LocalDate 적용되는지 확인 필요!
										//					ㄴ 스프링의 다른 기능 사용을 위해 날짜 타입 LocalDate 로 한다.
	private String writer;				//작성
	private boolean finished;			//완료 여부

}

//dbeaver 에서 작성해서 실행하세요.
//CREATE TABLE tbl_todo(
//		tno number(6) PRIMARY KEY,
//		title varchar2(100) NOT NULL,
//		dueDate DATE NOT NULL,
//		writer varchar2(50) NOT NULL,
//		finished number(2) DEFAULT 0		//참 거짓에서 0은 거짓, 0 이외의 값은 참
//	);

//CREATE SEQUENCE todoSeq START WITH 20111;