package com.example.vaccineManagement.Controllers;

import com.example.vaccineManagement.Dtos.requestDtos.UpdateEmailDto;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    @GetMapping("/get-vaccination-date")
    public Date getVaccinationDate(@RequestParam("userId") Integer userId)
    {
        return userService.getVaccDate(userId);
    }

    @PutMapping("/updateEmailId")
    public String updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
        return userService.updateEmail(updateEmailDto);
    }

    @GetMapping("/getByEmail/{emailId}")
    public User getByEmail(@PathVariable("emailId") String emailId)
    {
        return userService.getUserByEmail(emailId);
    }

}
