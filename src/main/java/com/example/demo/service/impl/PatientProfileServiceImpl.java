package com.example.demo.service.impl;

import com.example.demo.entity.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repository;

    public PatientProfileServiceImpl(PatientProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientProfile createPatient(PatientProfile patient) {

        if (repository.existsByEmail(patient.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (repository.existsByPatientId(patient.getPatientId())) {
            throw new RuntimeException("PatientId already exists");
        }

        return repository.save(patient);
    }

    @Override
    public PatientProfile getPatientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ResourceNotFoundException"));
    }

    @Override
    public List<PatientProfile> getAllPatients() {
        return repository.findAll();
    }

    @Override
    public PatientProfile updatePatientStatus(Long id, boolean active) {
        PatientProfile patient = getPatientById(id);
        patient.setActive(active);
        return repository.save(patient);
    }
}
