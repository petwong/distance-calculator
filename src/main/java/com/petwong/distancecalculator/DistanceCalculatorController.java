package com.petwong.distancecalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DistanceCalculatorController {
    @Autowired
    private DistanceCalculatorService distanceCalculatorService;

    @GetMapping("/api/calculator/distance/sum")
    public String calculateDistance(@RequestBody DistanceCalculatorDTO dto) {
        if (dto.getInput1().value < 0 || dto.getInput2().value < 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Negative Values Not Acceptable.");
        }

        return distanceCalculatorService.sumOf(dto.getInput1(), dto.getInput2(), dto.getUom()).toString();
    }
}
