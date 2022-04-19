package com.ssafy.hw.model.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.hw.dto.User;

@Repository
public class UserRepoImpl implements UserRepo {

	@Override
	public int insert(User user) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int update(User user) {
		return 0;
	}

	@Override
	public User searchById(String id) {
		return null;
	}

	@Override
	public List<User> selectAll() {
		return null;
	}

	@Override
	public List<User> searchByName(String name) {
		return null;
	}

}
