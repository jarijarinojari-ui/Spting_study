package com.nojari.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class itemController {
    @GetMapping("/list")

    String hello(Model model) {
        model.addAttribute("name","홍길동");
        return "list.html";
    }
}
