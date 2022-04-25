package com.ssafy.hw.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hw.dto.User;
import com.ssafy.hw.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	
	@Autowired
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public UserRepo getUserRepo() {
		return this.userRepo;
	}
	
	@Override
	public int insert(User user) {
		return userRepo.insert(user);
	}

	@Override
	public int delete(String id) {
		return userRepo.delete(id);
	}

	@Override
	public int update(User user) {
		return userRepo.update(user);
	}

	@Override
	public User searchById(String id) {
		return userRepo.searchById(id);
	}

	@Override
	public List<User> selectAll() {
		return userRepo.selectAll();
	}

	@Override
	public List<User> searchByName(String name) {
		return userRepo.searchByName(name);
	}

}
