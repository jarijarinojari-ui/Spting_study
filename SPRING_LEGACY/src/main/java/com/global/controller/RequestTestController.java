package com.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.dto.User;

@Controller
@RequestMapping(value = "/test")
public class RequestTestController {

    private final HelloController helloController;

    RequestTestController(HelloController helloController) {
        this.helloController = helloController;
    }
	
    // /test/01?name=hong&age=20
	@RequestMapping(value = "/01", method = {RequestMethod.GET, RequestMethod.POST})
	public void test01(@RequestParam(required = true) String name, 
			@RequestParam(defaultValue = "30") int age) {
		System.out.printf("name:%s, age:%d \n", name, age);
	}
	// RequestParam
	
	@RequestMapping(value = "/02/{name}/{age}", method = RequestMethod.GET)
	public void test02(
		@PathVariable(value = "name") String name
		, @PathVariable(value = "age") int age
		) {
			System.out.printf("name:%s, age%d, \n", name, age);
		}
	// Request value
	
	@RequestMapping(value = "/03", method = RequestMethod.POST)
	public void test03(@RequestBody User user) {
		System.out.println(user);
	}
	
	@RequestMapping(value =  "/04", method = RequestMethod.POST)
	public void test04(@ModelAttribute User user) {
		System.out.println(user);
	}
	
	@RequestMapping(value = "/05", method = RequestMethod.GET)
	public void test05(
		@RequestHeader String name
		, @RequestHeader int age
		) {
			System.out.printf("name:%s, age:%d \n", name, age);
		}
	
	@RequestMapping(value = "/06", method = RequestMethod.GET)
	public String test06(
		@CookieValue(name = "JSESSIONID", required = false) String JsessionId) {
		System.out.printf("JsessionId: %s\n", JsessionId);
		return "hi";
	}
}
