package org.iclass.mvc.dao;

import java.util.Map;

import org.iclass.mvc.dto.BookUser;

public interface BookuserMapper {

	BookUser login(Map<String, String> map);
	int join(BookUser dto);
}
