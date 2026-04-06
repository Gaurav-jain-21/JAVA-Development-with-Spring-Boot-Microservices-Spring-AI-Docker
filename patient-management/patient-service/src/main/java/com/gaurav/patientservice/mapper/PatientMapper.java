package com.gaurav.patientservice.mapper;

import com.gaurav.patientservice.dtoo.PatientResponseDTO;
import com.gaurav.patientservice.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientDTO= new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setDateOfBirth(patient.getDate_of_birth().toString());

        return patientDTO;
    }
}
