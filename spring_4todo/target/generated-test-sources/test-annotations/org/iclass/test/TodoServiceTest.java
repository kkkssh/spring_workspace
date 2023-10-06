package org.iclass.test;

import static org.junit.jupiter.api.Assertions.*;

import org.iclass.dto.PageRequestDTO;
import org.iclass.dto.PageResponseDTO;
import org.iclass.dto.TodoDto;
import org.iclass.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
class TodoServiceTest {
	
	@Autowired
	TodoService todoService;

	@Test
	void paging() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.of(1,5);

		log.info(">>>>>>>>>>>>> page request Dto {}",pageRequestDTO);
		
		PageResponseDTO<TodoDto> responseDTO = todoService.getList(pageRequestDTO);
		log.info(">>>>>>>>>>>>> page response Dto {}",responseDTO);
		
		responseDTO.getDtoList().stream()
		.forEach(todoDto -> log.info("dto : {}",todoDto));
		
		assertNotNull(responseDTO);
	}

}
