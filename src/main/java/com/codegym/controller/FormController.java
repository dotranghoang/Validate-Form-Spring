package com.codegym.controller;

import com.codegym.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @GetMapping("/")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("form",new Form());

        return modelAndView;
    }

    @PostMapping("/validate")
    public ModelAndView checkValidation(@Validated @ModelAttribute("form") Form form, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/index");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("/result");
        return modelAndView;
    }
}
