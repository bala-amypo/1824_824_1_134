package com.example.demo.controller;

import com.example.demo.entity.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviation-rules")
public class DeviationRuleController {

    private final DeviationRuleService service;

    public DeviationRuleController(DeviationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public DeviationRule createRule(@RequestBody DeviationRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/surgery/{surgeryType}")
    public List<DeviationRule> getRulesBySurgery(@PathVariable String surgeryType) {
        return service.getRulesBySurgery(surgeryType);
    }

    @GetMapping
    public List<DeviationRule> getAllRules() {
        return service.getAllRules();
    }
}
