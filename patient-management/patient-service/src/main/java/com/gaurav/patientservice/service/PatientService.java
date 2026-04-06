package com.gaurav.patientservice.service;

import com.gaurav.patientservice.dtoo.PatientRequestDTO;
import com.gaurav.patientservice.dtoo.PatientResponseDTO;
import com.gaurav.patientservice.exception.EmailAlreadyExistsException;
import com.gaurav.patientservice.mapper.PatientMapper;
import com.gaurav.patientservice.model.Patient;
import com.gaurav.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatient(){
        List<Patient> patients= patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs= patients.stream().map(PatientMapper::toDTO).toList();
        return patientResponseDTOs;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exist "+patientRequestDTO.getEmail());
        }

        Patient newPatient= patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);

    }
}
