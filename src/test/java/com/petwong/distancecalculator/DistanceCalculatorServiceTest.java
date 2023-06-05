package com.petwong.distancecalculator;

import org.elasticsearch.common.unit.DistanceUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DistanceCalculatorServiceTest {

    private DistanceCalculatorService dcService = new DistanceCalculatorService();

    @ParameterizedTest
    @MethodSource
    public void test_sumOfDistance(DistanceUnit.Distance a, DistanceUnit.Distance b, DistanceUnit uom, DistanceUnit.Distance expected) {
        Assertions.assertEquals(expected, dcService.sumOf(a, b, uom));
    }

    static Stream<Arguments> test_sumOfDistance() {
        return Stream.of(
                Arguments.of(
                        new DistanceUnit.Distance(1, DistanceUnit.METERS),
                        new DistanceUnit.Distance(2, DistanceUnit.KILOMETERS),
                        DistanceUnit.KILOMETERS,
                        new DistanceUnit.Distance(2.001, DistanceUnit.KILOMETERS)),
                Arguments.of(
                        new DistanceUnit.Distance(0, DistanceUnit.METERS),
                        new DistanceUnit.Distance(2, DistanceUnit.YARD),
                        DistanceUnit.KILOMETERS,
                        new DistanceUnit.Distance(0.0018288, DistanceUnit.KILOMETERS))
        );
    }
}
