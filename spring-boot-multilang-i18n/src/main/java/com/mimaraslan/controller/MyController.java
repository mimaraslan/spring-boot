package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1/")
public class MyController {

    //Internationalization i18n
    @Autowired
    private MessageSource messageSource;

    //  http://localhost:8082/api/v1/my/i18n/v1
    @GetMapping(path = "my/i18n/v1")
    public String getInfoInternationalization1(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage(
                "welcome.message", null,
                "Default message",
                locale);
         }

    //  http://localhost:8082/api/v1/my/i18n/v2
    @GetMapping(path = "my/i18n/v2")
    public String getInfoInternationalization2() {
        return messageSource.getMessage(
                "welcome.message", null,
                "Default message",
                LocaleContextHolder.getLocale());
    }

}