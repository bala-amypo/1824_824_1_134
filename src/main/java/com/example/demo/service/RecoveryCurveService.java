package com.example.recovery.service;

import com.example.recovery.entity.RecoveryCurveProfile;

import java.util.List;

public interface RecoveryCurveService {

    RecoveryCurveProfile createCurveEntry(RecoveryCurveProfile entry);

    List<RecoveryCurveProfile> getCurveForSurgery(String surgeryType);

    List<RecoveryCurveProfile> getAllCurves();
}
