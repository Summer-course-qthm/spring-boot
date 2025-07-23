package com.example.hoche.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hoche.service.AppService;

@RestController
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping("/") // hoặc dùng @RequestMapping(value = "/", method = RequestMethod.GET)
    public String jhjkasdf() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/age") // hoặc dùng @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Integer> home() { //mapping
        int age = appService.GetAge();
        return ResponseEntity.ok(age);  //status code -> restful
    }

}
