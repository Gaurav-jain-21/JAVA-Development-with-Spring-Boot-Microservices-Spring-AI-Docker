package com.gaurav.patientservice.service;

import com.gaurav.patientservice.dtoo.PatientRequestDTO;
import com.gaurav.patientservice.dtoo.PatientResponseDTO;
import com.gaurav.patientservice.exception.EmailAlreadyExistsException;
import com.gaurav.patientservice.exception.PatientNotFoundException;
import com.gaurav.patientservice.mapper.PatientMapper;
import com.gaurav.patientservice.model.Patient;
import com.gaurav.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO  patientRequestDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient not found with Id : " + id));
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exist "+patientRequestDTO.getEmail());
        }
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDate_of_birth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }
}
