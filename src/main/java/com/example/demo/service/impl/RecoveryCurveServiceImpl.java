package com.example.recovery.service.impl;

import com.example.recovery.entity.RecoveryCurveProfile;
import com.example.recovery.repository.RecoveryCurveProfileRepository;
import com.example.recovery.service.RecoveryCurveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveServiceImpl implements RecoveryCurveService {

    private final RecoveryCurveProfileRepository repository;

    public RecoveryCurveServiceImpl(RecoveryCurveProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecoveryCurveProfile createCurveEntry(RecoveryCurveProfile entry) {
        return repository.save(entry);
    }

    @Override
    public List<RecoveryCurveProfile> getCurveForSurgery(String surgeryType) {
        return repository.findBySurgeryTypeOrderByDayNumberAsc(surgeryType);
    }

    @Override
    public List<RecoveryCurveProfile> getAllCurves() {
        return repository.findAll();
    }
}
