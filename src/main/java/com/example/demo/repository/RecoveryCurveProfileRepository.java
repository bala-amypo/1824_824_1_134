package com.example.recoverycurve.repository;

import com.example.recoverycurve.entity.RecoveryCurveProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecoveryCurveProfileRepository
        extends JpaRepository<RecoveryCurveProfile, Long> {

    List<RecoveryCurveProfile> findBySurgeryTypeOrderByDayNumberAsc(String surgeryType);
}
