package com.example.vaccineManagement.Services;

import com.example.vaccineManagement.Exceptions.EmailEmptyException;
import com.example.vaccineManagement.Exceptions.EmailIdAlreadyExistsException;
import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public String addDoc(Doctor doctor) throws Exception{
        if(doctor.getEmailId()==null)
        {
            throw new EmailEmptyException("Email id is mandatory");
        }
        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null)
        {
            throw new EmailIdAlreadyExistsException("Doctor with this email id already exists");
        }
        doctorRepository.save(doctor);
        return "Doctor has been added.";
    }
}
