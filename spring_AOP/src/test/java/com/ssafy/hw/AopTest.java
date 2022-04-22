package com.ssafy.hw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.hw.dto.User;
import com.ssafy.hw.model.service.UserService;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AopTest{	
	
	// 서비스 빈 가져오기, 어노테이션을 통해 설정파일을 불러왔으므로 어노테이션 기반 빈 사용
	@Autowired
	UserService service;

	@Test
	public void testAOP() {
		// LoggingAspect에서 작성한 로그가 제대로 출력되는지 확인
		service.insert(new User("ssafy", "1234", "김싸피" , "ssafy@ssafy.com", 27));
		service.selectAll();
	}
}

