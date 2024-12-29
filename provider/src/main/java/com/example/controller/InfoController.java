package com.example.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/info")
public class InfoController {
    @PostMapping
    public User getInfo() {
        return new User("john", 20);
    }
}
