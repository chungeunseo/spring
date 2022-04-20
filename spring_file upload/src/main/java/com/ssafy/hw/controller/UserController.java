package com.ssafy.hw.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.hw.dto.User;

// 이 클래스가 컨트롤러 임을 어노테이션으로 설정, 컴포넌트 스캔을 통해 빈으로 등록
@Controller
public class UserController {
	
	// 파일처리를 위해 시스템 정보를 가져오는 로더 (빈으로 주입)
	@Autowired
	ResourceLoader resLoader;
	
	/**
	 * '/' 또는 '/index' 요청이 get 방식으로 들어왔을 때 index로 연결한다.
	 * @return
	 */
	@GetMapping({"/", "/index" })
	public String showIndex() {
		return "index";
	}
	
	/**
	 * '/regist' 요청이 get 방식으로 들어왔을 때 regist로 연결한다.
	 * @return
	 */
	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}

	/**
	 * '/regist' 요청이 post 방식으로 들어왔을 때 전달된 User 객체를 regist_result로 연결한다. 
	 * @param movie
	 * @return
	 */
	@PostMapping("/regist")
	// Img파일은 MultipartFile 타입으로 받는다고 따로 명시한다.
	public ModelAndView doRegist(User user, @RequestParam("userImg") MultipartFile file) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		// 파일을 업로드할 경로
		Resource res = resLoader.getResource("resources/upload");
		
		if(file != null && file.getSize() > 0) {
			// 파일 이름 가져와서 user 객체의 setter를 통해 설정
			user.setImg(file.getOriginalFilename());
			// 지정한 경로에 이미지 파일 저장
			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + user.getImg()));
		}
		// 어디로 연결할지 설정
		mav.setViewName("regist_result");
		// 전달할 객체
		mav.addObject("user", user);
		return mav;
	}
}
