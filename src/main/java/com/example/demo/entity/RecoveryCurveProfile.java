package com.example.recovery.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "recovery_curve_profile",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"surgery_type", "day_number"})
    }
)
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surgery_type", nullable = false)
    private String surgeryType;

    @Column(name = "day_number", nullable = false)
    private Integer dayNumber;

    @Column(name = "expected_pain_level", nullable = false)
    private Integer expectedPainLevel;

    @Column(name = "expected_mobility_level", nullable = false)
    private Integer expectedMobilityLevel;

    @Column(name = "expected_fatigue_level", nullable = false)
    private Integer expectedFatigueLevel;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Integer getExpectedPainLevel() {
        return expectedPainLevel;
    }

    public void setExpectedPainLevel(Integer expectedPainLevel) {
        this.expectedPainLevel = expectedPainLevel;
    }

    public Integer getExpectedMobilityLevel() {
        return expectedMobilityLevel;
    }

    public void setExpectedMobilityLevel(Integer expectedMobilityLevel) {
        this.expectedMobilityLevel = expectedMobilityLevel;
    }

    public Integer getExpectedFatigueLevel() {
        return expectedFatigueLevel;
    }

    public void setExpectedFatigueLevel(Integer expectedFatigueLevel) {
        this.expectedFatigueLevel = expectedFatigueLevel;
    }
}
