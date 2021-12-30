package com.project.booktime.controllers;

import com.project.booktime.exception.UserNotFoundException;
import com.project.booktime.model.dto.UserDTO;
import com.project.booktime.model.entity.User;
import com.project.booktime.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @PostMapping()
    public UserDTO add(@RequestBody User user) {
        return userService.add(user);
    }

    @DeleteMapping()
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }
}
