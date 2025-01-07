package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import jakarta.enterprise.inject.build.compatible.spi.Validation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/calculateIMC")
    ResponseEntity<?>   calculateIMC(@RequestBody   User user) {
        return ResponseEntity.ok(userService.calculateIMC(user));
    }
    @GetMapping("/sumOfDigits")
    ResponseEntity<?>   sumOfDigits(@RequestParam(value = "numLimit")   Integer numLimit) {
        return ResponseEntity.ok(userService.sumOfDigits(numLimit));
    }

    @PostMapping("/moveZerosToEnd")
    ResponseEntity<?>   moveZerosToEnd(@RequestBody  List<Object> array) {
        return ResponseEntity.ok(userService.moveZeros(array));
    }

}