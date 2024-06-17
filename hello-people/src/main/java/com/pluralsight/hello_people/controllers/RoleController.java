package com.pluralsight.hello_people.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @GetMapping("/role")
    public String getRole() throws Exception {
        throw new Exception("The API is not ready yet.");
    }

}
