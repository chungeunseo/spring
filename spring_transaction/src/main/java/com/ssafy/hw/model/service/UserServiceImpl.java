package com.ssafy.hw.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	// 트랜잭션 사용을 위한 어노테이션 설정
	@Transactional
	public int insert(User user) { //Service의 메서드: 논리적인 작업단위(DML)  - 두개 이상의 DML실행
		// 에러 발생 코드 삽입
//		user.setId("error"); // 아이디를 임의의 값으로 셋팅(@Transactional추가 전 테스트)
		user.setId("good");  // 아이디를 임의의 값으로 셋팅(@Transactional추가 후 테스트)
		userRepo.insert(user);
		return userRepo.insert(user);
		
		
		/*
		    try{
		    
		        dao.update();
		        dao.update();
		    
		        commit();
		    }catch(){
		        
		        rollback();
		    }
		 */
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
