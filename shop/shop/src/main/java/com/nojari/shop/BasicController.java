package com.nojari.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/date")
    @ResponseBody
    Date hello() {
        Date a = new Date();
        return a;
    }

    @GetMapping("/a")
    @ResponseBody
    String abc() {
        return "A의 세상입니다.";
    }

}
