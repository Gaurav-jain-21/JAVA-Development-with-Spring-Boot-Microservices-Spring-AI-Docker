package com.gaurav.security1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/patients")
    public List<Patient> getAllPatient(){
        return service.getAllPatient();
    }

    @PostMapping("/patient")
    public void addOne(@RequestBody Patient patient){
        service.addOnePatient(patient);
    }

}
