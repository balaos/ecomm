package com.sample.ecomm.others.validator;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/validate")
    public ResponseEntity<String> validateUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok("Validation successful: " + userDTO.getName());
    }
}

