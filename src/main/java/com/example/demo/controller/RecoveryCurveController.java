package com.example.recovery.controller;

import com.example.recovery.entity.RecoveryCurveProfile;
import com.example.recovery.service.RecoveryCurveService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
public class RecoveryCurveController {

    private final RecoveryCurveService service;

    public RecoveryCurveController(RecoveryCurveService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecoveryCurveProfile createCurveEntry(
            @RequestBody RecoveryCurveProfile profile) {
        return service.createCurveEntry(profile);
    }

    @GetMapping("/surgery/{surgeryType}")
    public List<RecoveryCurveProfile> getCurveForSurgery(
            @PathVariable String surgeryType) {
        return service.getCurveForSurgery(surgeryType);
    }

    @GetMapping
    public List<RecoveryCurveProfile> getAllCurves() {
        return service.getAllCurves();
    }
}
