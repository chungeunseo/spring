package com.ssafy.hw.model.repo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hw.dto.User;

//@Mapper
public interface UserRepo {
	
	int insert(User user);
	
	int delete(String id);
	
	int update(User user);
	
	User searchById(String id);
	
	List<User> selectAll();
	
	List<User> searchByName(String name);

}
