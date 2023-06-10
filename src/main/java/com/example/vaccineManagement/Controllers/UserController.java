package com.example.vaccineManagement.Controllers;

import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
