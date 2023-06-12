package com.example.vaccineManagement.Services;

import com.example.vaccineManagement.Dtos.requestDtos.UpdateEmailDto;
import com.example.vaccineManagement.Models.Dose1;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User user)
    {
        user=userRepository.save(user);
        return user;
    }
    public Date getVaccDate(Integer userId)
    {
        User user=userRepository.findById(userId).get();
        Dose1 dose=user.getDose();
        return dose.getVaccinationDate();
    }

    public String updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
       int userId=updateEmailDto.getUserId();
       User user=userRepository.findById(userId).get();
       user.setEmailId(updateEmailDto.getEmailId());
       userRepository.save(user);
       return "Email has been modified.";
    }

    public User getByEmail(String email)
    {
        User user=userRepository.findByEmailId(email);
        return user;
    }
}
