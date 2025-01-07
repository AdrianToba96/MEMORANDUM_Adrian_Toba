package com.company.controller;

import com.company.exception.InvalidIMCException;
import com.company.model.User;
import com.company.service.UserService;
import jakarta.enterprise.inject.build.compatible.spi.Validation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/calculateIMC")
    ResponseEntity<?>   calculateIMC(@Valid @RequestBody   User user, BindingResult bindingResult) {
        // Validar si hay errores de validación
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(errorMessage);

        }

        // Si la validación pasa, calcular el IMC
        try {
            return ResponseEntity.ok(userService.calculateIMC(user)); // Responder con el IMC calculado
        } catch (InvalidIMCException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: " + e.getMessage());
        }
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