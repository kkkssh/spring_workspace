package org.iclass.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.iclass.controller.TodoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

//Spring TestContext Framework를 Junit5에 포함시킬 수 있습니다.
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
class TodoControllerTest {

	MockMvc mockMvc;
	
	@Autowired
	TodoController todoController;
	
	@BeforeEach
	public void setup() {
	    this.mockMvc = MockMvcBuilders
	    		.standaloneSetup(todoController)
	            .addFilter(new CharacterEncodingFilter("UTF-8", true))
	 //           .apply(SecurityMockMvcConfigurers.springSecurity())
	            .build();
	}

	@Test
	public void todo_전체_조회_성공() throws Exception{
	    this.mockMvc
	            .perform(get("/todo/list"))
	            .andExpect(status().isOk())
	            .andDo(print());
	}
}






