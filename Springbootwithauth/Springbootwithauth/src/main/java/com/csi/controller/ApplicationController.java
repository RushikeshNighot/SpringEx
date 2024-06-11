package com.csi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){

        return  ResponseEntity.ok("Hello World");
    }


    @GetMapping("/services")
    public ResponseEntity<String> services(){
        return  ResponseEntity.ok("Software Developemnt web Services");
    }


}
