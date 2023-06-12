package com.example.vaccineManagement.Controllers;

import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/doctor")
@RestController

public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoc(@RequestBody Doctor doctor)
    {
        try{
            String response=doctorService.addDoc(doctor);
            return response;

        }catch(Exception e)
        {
            return e.getMessage();
        }
    }
}
