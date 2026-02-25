package com.global.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping(value = "/hi/")
	public String hello(Model model) {
		model.addAttribute("uuid", UUID.randomUUID().toString());
		return "hi";
	}
}
