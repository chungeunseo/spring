package com.ssafy.hw.controller;

import java.io.File;
import java.util.List;

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
import com.ssafy.hw.model.service.UserService;

// 이 클래스가 컨트롤러 임을 어노테이션으로 설정, 컴포넌트 스캔을 통해 빈으로 등록
@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
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
	public ModelAndView doRegist(User user, @RequestParam("userImg") MultipartFile file) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Resource res = resLoader.getResource("resources/upload");
		
		if(file != null && file.getSize() > 0) {
			user.setImg(file.getOriginalFilename());
			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + user.getImg()));
		}
		service.insert(user);
		
		mav.setViewName("regist_result");
		// 전달할 객체
		mav.addObject("user", user);
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView showList() {
		List<User> list = service.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.addObject("users", list);
		return mav;
	}
	
	@GetMapping("/search")
	public ModelAndView showSearchModelNameList(String name) {
		List<User> list = service.searchByName(name);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.addObject("users", list);
		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView doUpdate(User user) {
		service.update(user);
		
		List<User> list = service.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.addObject("users", list);
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView doDelete(String id) {
		service.delete(id);
		
		List<User> list = service.selectAll();
		System.out.println(list.get(0).toString());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.addObject("users", list);
		return mav;
	}
}
