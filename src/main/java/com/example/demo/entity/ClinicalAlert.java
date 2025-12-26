package com.example.healthcare.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clinical_alerts")
public class ClinicalAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientProfile patient;

    private LocalDate alertDate;

    @Column(nullable = false)
    private String severity; // LOW / MEDIUM / HIGH

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false)
    private Boolean resolved = false;

    // Constructors
    public ClinicalAlert() {}

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public PatientProfile getPatient() {
        return patient;
    }

    public void setPatient(PatientProfile patient) {
        this.patient = patient;
    }

    public LocalDate getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(LocalDate alertDate) {
        this.alertDate = alertDate;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
