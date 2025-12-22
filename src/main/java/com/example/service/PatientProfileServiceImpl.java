package com.example.demo.service;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public class PatientProfileServiceImpl {

    private final PatientProfileRepository repo;

    public PatientProfileServiceImpl(PatientProfileRepository repo) {
        this.repo = repo;
    }

    public PatientProfile createPatient(PatientProfile p) {
        if (repo.findByEmail(p.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        return repo.save(p);
    }

    public PatientProfile getPatientById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public List<PatientProfile> getAllPatients() {
        return repo.findAll();
    }

    public PatientProfile updatePatientStatus(Long id, boolean active) {
        PatientProfile p = getPatientById(id);
        p.setActive(active);
        return repo.save(p);
    }
}
