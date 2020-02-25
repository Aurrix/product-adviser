package se.seb.productadviser.product.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.seb.productadviser.product.dto.recommendation.CustomerDto;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class RecommendationControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void getRecommendations() throws Exception {
    CustomerDto customerDto =
        CustomerDto.builder().age(18).income(BigDecimal.TEN).student(true).build();

    ObjectMapper objectMapper = new ObjectMapper();

    mockMvc
        .perform(
            post("/recommendations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerDto)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[0].name").exists());
  }
}
