package com.example.GP.controller.Gongjeong;

import com.example.GP.dto.Gongjeong.CreateUserDTO;
import com.example.GP.dto.Gongjeong.UserDTO;
import com.example.GP.service.Gongjeong.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<CreateUserDTO.Response> createUser(
            @Valid @RequestBody CreateUserDTO.Request request) {

        return ResponseEntity.ok(CreateUserDTO.Response.from(
                userService.createUser(request)));
    }

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUser(
            @RequestParam("userId") Long userId) {

        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }
}
