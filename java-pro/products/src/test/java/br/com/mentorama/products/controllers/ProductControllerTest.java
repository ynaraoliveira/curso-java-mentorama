package br.com.mentorama.products.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldCreateANewProduct() throws Exception {
    String requestBody = "{\"description\":\"tv\",\"price\":5000,\"maxDiscount\":0.2,\"stockQuantity\":5}";

    mockMvc.perform(MockMvcRequestBuilders
            .post("/products")
            .content(requestBody)
            .contentType("application/json"))
            .andExpect(status().isCreated());
  }

  @Test
  public void shouldListAllProducts() throws Exception {
    String requestBody = "{\"description\":\"tv\",\"price\":5000,\"maxDiscount\":0.2,\"stockQuantity\":5}";

    String expectedResponseBody = "[{\"id\":1,\"description\":\"tv\",\"price\":5000.0,\"maxDiscount\":0.2,\"stockQuantity\":5}]";

    mockMvc.perform(MockMvcRequestBuilders
            .post("/products")
            .content(requestBody)
            .contentType("application/json"));

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/products"))
            .andExpect(status().isOk())
            .andReturn();

    String responseBody = result.getResponse().getContentAsString();

    assertNotNull(requestBody);
    assertEquals(expectedResponseBody, responseBody);
  }

  @Test
  public void shouldReturnAProductGivenItsId() throws Exception {
    String requestBody = "{\"description\":\"tv\",\"price\":5000,\"maxDiscount\":0.2,\"stockQuantity\":5}";

    String expectedResponseBody = "{\"id\":1,\"description\":\"tv\",\"price\":5000.0,\"maxDiscount\":0.2,\"stockQuantity\":5}";

    mockMvc.perform(MockMvcRequestBuilders
            .post("/products")
            .content(requestBody)
            .contentType("application/json"));

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/products/1"))
            .andExpect(status().isOk())
            .andReturn();

    String responseBody = result.getResponse().getContentAsString();

    assertEquals(expectedResponseBody, responseBody);
  }
}
