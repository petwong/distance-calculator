package com.petwong.distancecalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceCalculatorController {
    @Autowired
    private DistanceCalculatorService distanceCalculatorService;

    @GetMapping("/api/calculator/distance/sum")
    public String calculateDistance(@RequestBody DistanceCalculatorDTO dto) {
        return distanceCalculatorService.sumOf(dto.getInput1(), dto.getInput2(), dto.getUom()).toString();
    }
}
