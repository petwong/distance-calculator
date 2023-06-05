package com.petwong.distancecalculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.common.unit.DistanceUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistanceCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        DistanceCalculatorDTO dto = new DistanceCalculatorDTO();
        dto.setInput1(new DistanceUnit.Distance(1, DistanceUnit.KILOMETERS));
        dto.setInput2(new DistanceUnit.Distance(1, DistanceUnit.KILOMETERS));
        dto.setUom(DistanceUnit.METERS);

        ObjectMapper om = new ObjectMapper();

        mockMvc.perform(get("/api/calculator/distance/sum")
                        .content(om.writeValueAsString(dto)).contentType(MediaType.APPLICATION_JSON)
                )
                .andExpectAll(
                        status().isOk(),
                        content().string("2000.0m")
                );
    }
}
