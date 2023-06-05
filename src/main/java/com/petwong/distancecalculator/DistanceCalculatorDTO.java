package com.petwong.distancecalculator;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.elasticsearch.common.unit.DistanceUnit;

@Data
public class DistanceCalculatorDTO {
    @JsonDeserialize(using = DistanceDeserializer.class)
    private DistanceUnit.Distance input1;

    @JsonDeserialize(using = DistanceDeserializer.class)
    private DistanceUnit.Distance input2;

    private DistanceUnit uom;
}
