package org.iclass.mvc.dao;

import java.util.Map;

import org.iclass.mvc.dto.BookUser;

public interface BookUserMapper {
	int insert(BookUser dto);
	BookUser login(Map<String, String> map);

}
