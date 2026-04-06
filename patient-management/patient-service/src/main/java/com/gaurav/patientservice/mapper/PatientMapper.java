package com.gaurav.patientservice.mapper;

import com.gaurav.patientservice.dtoo.PatientRequestDTO;
import com.gaurav.patientservice.dtoo.PatientResponseDTO;
import com.gaurav.patientservice.model.Patient;

import java.time.LocalDate;

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

    public static Patient toModel(PatientRequestDTO patientDTO){
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAddress(patientDTO.getAddress());
        patient.setEmail(patientDTO.getEmail());
        patient.setDate_of_birth(LocalDate.parse(patientDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientDTO.getRegisteredDate()));

        return patient;
    }
}
