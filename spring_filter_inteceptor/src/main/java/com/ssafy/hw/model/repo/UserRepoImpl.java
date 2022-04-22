package com.ssafy.hw.model.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.hw.dto.User;

@Repository
public class UserRepoImpl implements UserRepo{

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User searchById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
