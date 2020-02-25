package se.seb.productadviser.product.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.seb.productadviser.product.dto.ProductDto;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class ProductControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getAll() throws Exception {
    mockMvc
        .perform(get("/products"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[0].id").exists());
  }

  @Test
  void getOne() throws Exception {
    mockMvc
        .perform(get("/products/ad44faf2-b7e2-4f02-b382-6e18f5977c18"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Current Account Plus"));
  }

  @Test
  void postOne() throws Exception {
    ProductDto productDto = ProductDto.builder()
        .id("")
        .name("Test Object")
        .build();

    ObjectMapper objectMapper = new ObjectMapper();

    mockMvc
        .perform(
            post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)))
        .andExpect(status().isCreated())
        .andExpect(header().exists("Location"));
  }

  @Test
  void putOne() throws Exception {

    ProductDto productDto = ProductDto.builder()
        .id("ad44faf2-b7e2-4f02-b382-6e18f5977c18")
        .name("John Snow")
        .build();

    ObjectMapper objectMapper = new ObjectMapper();

    mockMvc
        .perform(
            put("/products/ad44faf2-b7e2-4f02-b382-6e18f5977c18")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)))
        .andExpect(status().isAccepted());
  }

  @Test
  void deleteOne() throws Exception {
    mockMvc.perform(delete("/products/ad44faf2-b7e2-4f02-b382-6e18f5977c18"))
        .andExpect(status().isAccepted());
  }
}