package com.nojari.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class itemController {

    private final ItemRepository itemRepository;


    @GetMapping("/list")
    String hello(Model model) {
        List<Object> a = new ArrayList<>();


        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);

        return "list.html";
    }
}
