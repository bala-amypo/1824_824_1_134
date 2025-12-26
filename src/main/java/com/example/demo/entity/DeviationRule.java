package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "deviation_rules")
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String surgeryType;

    @Column(nullable = false)
    private String symptomParameter;

    @Column(nullable = false)
    private Integer thresholdDeviation;

    @Column(nullable = false)
    private Boolean active = true;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public String getSymptomParameter() {
        return symptomParameter;
    }

    public void setSymptomParameter(String symptomParameter) {
        this.symptomParameter = symptomParameter;
    }

    public Integer getThresholdDeviation() {
        return thresholdDeviation;
    }

    public void setThresholdDeviation(Integer thresholdDeviation) {
        this.thresholdDeviation = thresholdDeviation;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
