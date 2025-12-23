package com.example.recoverycurve.service;

import com.example.recoverycurve.entity.RecoveryCurveProfile;

import java.util.List;

public interface RecoveryCurveService {

    RecoveryCurveProfile createCurveEntry(RecoveryCurveProfile entry);

    List<RecoveryCurveProfile> getCurveForSurgery(String surgeryType);

    List<RecoveryCurveProfile> getAllCurves();
}
