package com.petwong.distancecalculator;

import org.elasticsearch.common.unit.DistanceUnit;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculatorService {
    public DistanceUnit.Distance sumOf(DistanceUnit.Distance a, DistanceUnit.Distance b, DistanceUnit uom) {
        double result = a.convert(uom).value + b.convert(uom).value;

        return new DistanceUnit.Distance(result, uom);
    }
}
