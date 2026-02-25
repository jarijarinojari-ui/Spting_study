package com.global.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.global.dto.User;

@Controller
@RequestMapping("/test2")
public class ResponceTestController {

	@GetMapping("/01")
	public String test01() {
		return "hello";
	}
	
	@GetMapping("/02")
	public ModelAndView test01(ModelAndView mav
			, @RequestParam(required = false) String msg) {
		mav.addObject("uuid", msg + UUID.randomUUID().toString());
		mav.setViewName("hello");
		return mav;
	}
	
	@GetMapping("/hello")
	public void test03() {
	}
	@GetMapping("/04")
	public String test04() {
		return "redirect:/test2/02"; 
	}
	
	@GetMapping("/05")
	public String test05(RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("msg", "redirect-");
		return "redirect:/test2/02?msg=redirect-";
	}
	
	@GetMapping("/06")
	public String test06() {
		return "forward:/test2/05";
	}
	
	@GetMapping("/07")
	@ResponseBody
	public String test07() {
		return "hello";
	}
	
	// ResponseTestController.java
	@RequestMapping("/08") // 브라우저에서 호출할 주소
	@ResponseBody
	public String test08() {
	    // WEB-INF/views/hi.jsp 파일을 찾아가도록 리턴
	    return "hi"; 
	}
	
	@GetMapping("/09")
	@ResponseBody
	public User test09() {
		User user = new User();
		user.setName("hong");
		user.setAge(20);
		return user;
	}

}
