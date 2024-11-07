package com.t03.e02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class NumberController {

    private List<Integer> numbers = new ArrayList<>();

    @GetMapping("/list")
    public String getNumbers(Model model) {
        model.addAttribute("numbers", numbers);
        model.addAttribute("total", numbers.size());
        return "index";
    }

    @PostMapping("/add")
    public String addNumber() {
        Random random = new Random();
        numbers.add(random.nextInt(100) + 1);  
        return "redirect:/list";  
    }

    @GetMapping("/delete")
    public String deleteNumber(@RequestParam("index") int index) {
        if (index >= 0 && index < numbers.size()) {
            numbers.remove(index);
        }
        return "redirect:/list";
    }
}
