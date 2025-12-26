package com.example.healthcare.service;

import com.example.healthcare.entity.ClinicalAlert;

import java.util.List;

public interface ClinicalAlertService {

    ClinicalAlert createAlert(ClinicalAlert alert);

    List<ClinicalAlert> getAlertsByPatient(Long patientId);

    ClinicalAlert resolveAlert(Long alertId);

    List<ClinicalAlert> getAllAlerts();
}
