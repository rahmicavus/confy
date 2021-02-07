package com.pluralsight.confy.controller;

import com.pluralsight.confy.model.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class WelcomeController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    @GetMapping("/form")
    public String showForm(PersonForm form, Model model){
        model.addAttribute("occupation","Computer Engineer");
        return "form";
    }

    @PostMapping("/form")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }

        return "redirect:/result";
    }

    @GetMapping("/hello")
    public String welcome(Map<String,Object> map)
    {
        map.put("message","Merhaba Volkan");
        return "welcome";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
