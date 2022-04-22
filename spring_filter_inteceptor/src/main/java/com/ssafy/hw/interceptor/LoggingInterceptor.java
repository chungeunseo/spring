package com.ssafy.hw.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 구현할 인터페이스 
public class LoggingInterceptor implements HandlerInterceptor {
	
	// 로그를 남기기위해 Logger 얻기
	private static Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
	
	// 컨트롤러 호출 전 처리
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.debug("request url : " + request.getRequestURL());
		logger.debug("request method : " + request.getMethod());
		
		return true;
	}
	
	// 컨트롤러 호출 후 처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//        modelAndView.setViewName("index");
		logger.debug("response : " + modelAndView.getViewName());
	}
	
}
