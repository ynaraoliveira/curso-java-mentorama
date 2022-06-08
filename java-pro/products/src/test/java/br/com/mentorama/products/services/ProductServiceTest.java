package br.com.mentorama.products.services;

import br.com.mentorama.products.models.Product;
import br.com.mentorama.products.models.SalesRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

  @Autowired
  ProductService productService;

//  @Test
  public void shouldCalculateTotalPrice() {
    Product product = new Product(UUID.randomUUID(), "tv", 100.0, 0.1, 3);
    productService.findById(product.getId());
    SalesRequestDTO salesRequestDTO = new SalesRequestDTO(UUID.randomUUID(), 1, 0.1);

    assertEquals(90, productService.sellProducts(salesRequestDTO));
  }
}
