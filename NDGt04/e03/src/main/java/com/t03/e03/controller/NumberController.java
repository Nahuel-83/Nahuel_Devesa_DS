package com.t03.e03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.t03.e03.service.NumberServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class NumberController {

    private NumberServiceImpl numberServiceImpl;

    public NumberController(NumberServiceImpl numberServiceImpl) {
        this.numberServiceImpl = numberServiceImpl;
    }

    @GetMapping("/list")
    public String getNumbers(Model model) {
        model.addAttribute("numbers", numberServiceImpl.getNumbers());
        model.addAttribute("total", numberServiceImpl.getNumbers().size());
        return "index";
    }

    @PostMapping("/add")
    public String addNumber() {
        numberServiceImpl.addNumber();
        return "redirect:/list";  
    }

    @GetMapping("/delete")
    public String deleteNumber(@RequestParam("index") int index) {
        numberServiceImpl.deleteNumber(index);
        return "redirect:/list";
    }
}
