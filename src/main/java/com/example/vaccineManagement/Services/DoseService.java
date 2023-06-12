package com.example.vaccineManagement.Services;

import com.example.vaccineManagement.Models.Dose1;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Repository.DoseRepository;
import com.example.vaccineManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    UserRepository userRepository;

    public String giveDose1(String doseId,Integer userId)
    {
        User user=userRepository.findById(userId).get();
        Dose1 dose1=new Dose1();
        dose1.setDoseId(doseId);
        dose1.setUser(user);
        user.setDose(dose1);
        userRepository.save(user);
        return "Dose1 given to user successfully";
    }
}
