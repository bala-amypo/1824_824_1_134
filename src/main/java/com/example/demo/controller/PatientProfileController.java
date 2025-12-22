package com.example.demo.controller;

import com.example.demo.entity.PatientProfile;
import com.example.demo.service.PatientProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientProfileController {

    private final PatientProfileService patientService;

    public PatientProfileController(PatientProfileService patientService) {
        this.patientService = patientService;
    }
    @PostMapping
    public ResponseEntity<PatientProfile> createPatient(
            @RequestBody PatientProfile patient) {

        PatientProfile saved = patientService.createPatient(patient);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientProfile> getPatientById(
            @PathVariable Long id) {

        return ResponseEntity.ok(patientService.getPatientById(id));
    }
    @GetMapping
    public ResponseEntity<List<PatientProfile>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<PatientProfile> updatePatientStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return ResponseEntity.ok(
                patientService.updatePatientStatus(id, active)
        );
    }
}
