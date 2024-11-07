package com.e01.e01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.e01.e01.modelo.FormInfo;

@Controller
public class FormController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "form"; 
    }

    @PostMapping("/myForm/submit")
    public String showMyFormSubmit(FormInfo formInfo, Model model) {
        formInfo.setNombre(formInfo.getNombre().toUpperCase());
        formInfo.setEdad(formInfo.getEdad());
        model.addAttribute("formInfo", formInfo);
        return "formSubmit"; 
    }
}
