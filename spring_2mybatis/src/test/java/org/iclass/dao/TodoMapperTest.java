package org.iclass.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import org.iclass.config.MybatisConfig;
import org.iclass.dto.PageRequestDTO;
import org.iclass.dto.TodoDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@DisplayName("todo mapper 의 crud 동작이 되어야합니다.")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MybatisConfig.class)
@Slf4j
class TodoMapperTest {
   
   @Autowired
   private TodoMapper dao;

   @Test
   @DisplayName("insert 를 여러 행 해봅시다. 페이징 테스트를 위한 데이터 추가")
   void insertMany() {		//i는 1부터 19까지 실행됩니다.
	   IntStream.range(1, 20).forEach(i ->{
	      TodoDto dto = TodoDto.builder()
	    		  .dueDate(LocalDate.of(2023, 10, 3))
	    		  .title("집에갈래 " + i)
	    		  .writer("twice" + (char)('a'+i))
	    		  .finished(true)
	    		  .build();
	   
	      dao.insert(dto); }
			   );
   }
   
   @Test
   @DisplayName("다양한 조건으로 검색합니다.")
   void search() {
//	   PageRequestDTO pageRequestDTO = PageRequestDTO.of(1, 5, new String[] {"t","w"},"공부",false,null,null);
	   PageRequestDTO pageRequestDTO = PageRequestDTO.of(1, 30, null, null, false, 
			   				LocalDate.of(2023, 9,29),LocalDate.of(2023, 10, 2));
	   
	   List<TodoDto> list = dao.selectPageList(pageRequestDTO);
	   list.forEach(dto -> log.info(">>>>> search result : {}", dto));
   
	   log.info(">>>>> total count : {}", dao.getCount(pageRequestDTO));
   }
   
   @Disabled
   @Test
   @DisplayName("todo 테이블에 insert가 되어야 합니다.")
   void insert() {
      TodoDto dto = TodoDto.builder()
            .dueDate(LocalDate.of(2023, 10, 1))
            .title("mybatis 공부")
            .writer("상희")
            .build();
      log.info(">>>>> 저장할 dto : {} " , dto);
      assertNotEquals(0, dao.insert(dto));
   }
   
   @Test
   @DisplayName("tno 1개를 조건값으로 조회가 되어야 합니다.")
   void selectOne() {
	   TodoDto dto = dao.selectOne(20111L);
	   log.info(">>>>> 조회된 dto : {}", dto);
	   assertNotNull(dto);	   
	   
   }

}
