package com.gaurav.security1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepo repo;


    public List<Patient> getAllPatient() {
        return repo.findAll();
    }

    public void addOnePatient(Patient patient) {
        repo.save(patient);
    }
}
