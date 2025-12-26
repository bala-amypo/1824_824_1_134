package com.example.healthcare.repository;

import com.example.healthcare.entity.ClinicalAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicalAlertRepository extends JpaRepository<ClinicalAlert, Long> {

    List<ClinicalAlert> findByPatientId(Long patientId);
}
