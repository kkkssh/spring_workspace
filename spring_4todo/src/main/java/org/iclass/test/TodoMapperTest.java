package org.iclass.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.List;

import org.iclass.dao.TodoMapper;
import org.iclass.dto.PageRequestDTO;
import org.iclass.dto.TodoDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
class TodoMapperTest {
	private final Logger logger = LoggerFactory.getLogger(TodoMapperTest.class);
	
	@Autowired
	private TodoMapper todoMapper;
	
	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void getTime() {
		logger.info(">>>>>>>> {}",todoMapper.getTime());
		assertNotNull(todoMapper);
	}
	
	@Test
	@Disabled
	void insert() {
		TodoDto dto = TodoDto.builder()
				.writer("momo")
				.title("스프링웹")
				.dueDate(LocalDate.of(2023, 10, 10))
				.build();
		
		logger.info(">>>>>>>> {}" , dto);
		assertNotEquals(0, todoMapper.insert(dto));
		
	}

	@Test
	void selectList() {
				
		List<TodoDto> list = todoMapper.selectList(PageRequestDTO.of(1, 5));
		
		assertNotEquals(0, list.size());
	}

}
