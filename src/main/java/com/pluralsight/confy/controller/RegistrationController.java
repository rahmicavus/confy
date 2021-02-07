package com.pluralsight.confy.controller;


import com.pluralsight.confy.model.Registration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class RegistrationController implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver(){
        final SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en", "US"));
        return localeResolver;
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("registration") Registration registration){

        return "registration";
    }

    @PostMapping("/registration")
    public String addRegistration(@Valid Registration registration, BindingResult result)
    {
        if(result.hasErrors()){
            System.out.println("There were errors");
            return "registration";
        }

        System.out.println(registration.getName());
        return "redirect:/result";

    }
}
