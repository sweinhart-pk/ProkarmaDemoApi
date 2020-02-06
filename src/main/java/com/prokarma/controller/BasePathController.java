package com.prokarma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasePathController {

    private static String version = "1.0";
    
    @GetMapping("/dealer")
    public ResponseEntity<Void> getBasePath() {
        return new ResponseEntity("Service is UP and running on version "+ version, HttpStatus.OK);
    }
}