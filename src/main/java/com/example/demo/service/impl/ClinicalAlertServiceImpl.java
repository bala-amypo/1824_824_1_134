package com.example.healthcare.service.impl;

import com.example.healthcare.entity.ClinicalAlert;
import com.example.healthcare.repository.ClinicalAlertRepository;
import com.example.healthcare.service.ClinicalAlertService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRepository alertRepository;

    public ClinicalAlertServiceImpl(ClinicalAlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public ClinicalAlert createAlert(ClinicalAlert alert) {
        alert.setAlertDate(LocalDate.now());
        alert.setResolved(false);
        return alertRepository.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAlertsByPatient(Long patientId) {
        return alertRepository.findByPatientId(patientId);
    }

    @Override
    public ClinicalAlert resolveAlert(Long alertId) {
        ClinicalAlert alert = alertRepository.findById(alertId)
                .orElseThrow(() -> new RuntimeException("Alert not found"));

        alert.setResolved(true);
        return alertRepository.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAllAlerts() {
        return alertRepository.findAll();
    }
}
