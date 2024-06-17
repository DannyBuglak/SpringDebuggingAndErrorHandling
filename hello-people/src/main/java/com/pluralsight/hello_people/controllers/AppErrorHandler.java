package com.pluralsight.hello_people.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppErrorHandler implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        return "Oops, something went wrong.";
    }

}
