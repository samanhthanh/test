package com.example.test.controller;

import com.example.test.services.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/guest")
public class GuestController {
    private GuestService guestService;

    @GetMapping("/calculator")
    public ResponseEntity<?> getAgeOrYearOfBirth(@RequestParam(name = "age", required = false) Integer age, @RequestParam(name = "yearOfBirth", required = false) Integer yearOfBirth){
        return new ResponseEntity<>(guestService.getAgeOrYearOfBirth(age, yearOfBirth), HttpStatus.OK);
    }

}
