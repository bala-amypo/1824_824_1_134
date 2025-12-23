package com.example.recoverycurve.controller;

import com.example.recoverycurve.entity.RecoveryCurveProfile;
import com.example.recoverycurve.service.RecoveryCurveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
public class RecoveryCurveController {

    private final RecoveryCurveService recoveryCurveService;

    public RecoveryCurveController(RecoveryCurveService recoveryCurveService) {
        this.recoveryCurveService = recoveryCurveService;
    }

    @PostMapping
    public ResponseEntity<RecoveryCurveProfile> createCurveEntry(
            @RequestBody RecoveryCurveProfile profile) {

        RecoveryCurveProfile savedProfile =
                recoveryCurveService.createCurveEntry(profile);

        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }

    @GetMapping("/surgery/{surgeryType}")
    public ResponseEntity<List<RecoveryCurveProfile>> getCurveForSurgery(
            @PathVariable String surgeryType) {

        return ResponseEntity.ok(
                recoveryCurveService.getCurveForSurgery(surgeryType)
        );
    }

    @GetMapping
    public ResponseEntity<List<RecoveryCurveProfile>> getAllCurves() {
        return ResponseEntity.ok(recoveryCurveService.getAllCurves());
    }
}
