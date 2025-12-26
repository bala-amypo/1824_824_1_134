package com.example.healthcare.controller;

import com.example.healthcare.entity.ClinicalAlert;
import com.example.healthcare.service.ClinicalAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService alertService;

    public ClinicalAlertController(ClinicalAlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ClinicalAlert createAlert(@RequestBody ClinicalAlert alert) {
        return alertService.createAlert(alert);
    }

    @GetMapping("/patient/{patientId}")
    public List<ClinicalAlert> getAlertsByPatient(@PathVariable Long patientId) {
        return alertService.getAlertsByPatient(patientId);
    }

    @PutMapping("/{alertId}/resolve")
    public ClinicalAlert resolveAlert(@PathVariable Long alertId) {
        return alertService.resolveAlert(alertId);
    }

    @GetMapping
    public List<ClinicalAlert> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
