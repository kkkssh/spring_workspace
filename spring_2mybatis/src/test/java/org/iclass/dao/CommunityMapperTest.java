package org.iclass.dao;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.iclass.config.MybatisConfig;
import org.iclass.dto.Community;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@DisplayName("CommunityMapper 구현체 생성확인합니다.")
//spring의 test클래스 설정
@ExtendWith(SpringExtension.class)		//테스트 클래스 기능을 위한 애노테이션
//@ContextConfiguration(locations ="classpath:META-INF/spring/applicationContext.xml" )
@ContextConfiguration(classes = MybatisConfig.class)	//테스트 클래스에서 설정파일 가져오기
@Slf4j
class CommunityMapperTest {
	
	@Autowired		//테스트 코드에서는 필드 주입
	private ApplicationContext context;
	
	@Autowired
	private CommunityMapper dao;
	
	@DisplayName("context, dao bean 생성 확인합니다.")	//설명
	@Test
	@Disabled		//테스트에서 제외할 때 사용하는 애노테이션
	void bean() {
		log.debug("mapper 인터페이스의 구현체 - {}",dao.getClass().getName());
		assertNotNull(context);
		assertNotNull(dao);
	}
	
	
	@DisplayName("list 로 가져온 개수와 count 함수 결과는 같아야 합니다.")
	@Test
//	@Disabled
	void list() {
		List<Community> list = dao.list();
		int size = list.size();
		int count = dao.count();
		log.info("select 전체 크기 : {} , select count : {}",size, count);
		
		assertEquals(count, size);
	}
	
	@DisplayName("insert 확인")
	@Test
//	@Disabled
//	void insert() {
////		Community vo = new Community(64,"twice","ff","dd",0,null,"127.0.0.1","0");
//		Community vo = Community.builder()
//	               .writer("sana")
//	               .title("안녕하세요~!")
//	               .content("나는 사실 사나가 아니라 상희다")
//	               .ip("127.0.0.1")
//	               .build();
//		log.debug("insert: {}" , dao.insert(vo));
//	}
	void insert() {
	      
	      log.info("insert() 실행 ");
	      Community vo = Community.builder().title("홍승희의김민섭레시피100선").writer("홍승희")
	                  .content("민섭아 꺼져").ip("192.168.0.26").build();
	      int result = dao.insert(vo);
	      log.info("insert 후 결과값 : {}",result);
	      log.info("insert 후 idx : {}",vo.getIdx());
	      
	      assertNotEquals(0, result);
	   }

}
