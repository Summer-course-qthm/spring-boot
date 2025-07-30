package com.example.demo.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/") // hoặc dùng @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Hello anhminh ngu như cho ăn cơm nguội!"; // Trả về chuỗi văn bản
    }

    //e@PostMapping("/student")

}