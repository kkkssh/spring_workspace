package org.iclass;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.iclass.mvc.dao.CommunityCommentsMapper;
import org.iclass.mvc.dto.CommunityComments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@DisplayName("Comments 구현체 생성확인")
@ExtendWith(SpringExtension.class)								
//▼ MybatisConfig.java 에서 @Bean 을 전부 지워야 사용 가능 ▼
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")			//테스트 클래스에서 설정파일 가져오기
@Slf4j
class CommentsMapperTest {
	
	
	@Autowired
	private CommunityCommentsMapper dao;
	
	@DisplayName("메인글 515번 - 댓글 리스트")
	@Test
	void list() {
		long idx = 515L;
		List<CommunityComments> list = dao.commentsList(idx);
		list.forEach(dto -> log.info("★★★★★★메인글 515번 - 댓글 리스트 : {}",dto));
		
		assertNotNull(list);
		
	}

}
