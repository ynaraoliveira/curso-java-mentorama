package br.com.mentorama.products.services;

import br.com.mentorama.products.models.Product;
import br.com.mentorama.products.models.SalesRequestDTO;
import br.com.mentorama.products.models.SalesResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductServiceTest {

  @Autowired
  ProductService productService;

  @Test
  public void shouldCalculateTotalPrice() {
    Product product = generateProduct();
    productService.add(product);

    SalesRequestDTO salesRequestDTO = new SalesRequestDTO(1, 1, 0.1);
    productService.setFinalProductQuantity(salesRequestDTO);
    productService.setFinalDiscount(salesRequestDTO);
    Double finalPrice = productService.calcaulateFinalPrice(salesRequestDTO);

    assertEquals(90.0, finalPrice);
  }

  @Test
  public void shouldCalculateTotalPriceWhenDiscountIsHigherThanAllowed() {
    Product product = generateProduct();
    productService.add(product);

    SalesRequestDTO salesRequestDTO = new SalesRequestDTO(1, 1, 0.20);
    productService.setFinalProductQuantity(salesRequestDTO);
    productService.setFinalDiscount(salesRequestDTO);
    Double finalPrice = productService.calcaulateFinalPrice(salesRequestDTO);

    assertEquals(90.0, finalPrice);
  }

  @Test
  public void shouldCalculateTotalPriceWhenDiscountIsLowerThanAllowed() {
    Product product = generateProduct();
    productService.add(product);

    SalesRequestDTO salesRequestDTO = new SalesRequestDTO(1, 1, 0.05);
    productService.setFinalProductQuantity(salesRequestDTO);
    productService.setFinalDiscount(salesRequestDTO);
    Double finalPrice = productService.calcaulateFinalPrice(salesRequestDTO);

    assertEquals(95.0, finalPrice);
  }

  @Test
  public void shouldSellAProduct() {
    Product product = generateProduct();
    productService.add(product);

    SalesRequestDTO salesRequestDTO = new SalesRequestDTO(1, 1, 0.05);
    productService.setFinalProductQuantity(salesRequestDTO);
    productService.setFinalDiscount(salesRequestDTO);
    SalesResponseDTO salesResponseDTO = productService.sellProducts(salesRequestDTO);

    assertNotNull(salesResponseDTO);
  }

  private Product generateProduct() {
    Product product = new Product();
    product.setId(1);
    product.setDescription("tv");
    product.setPrice(100.00);
    product.setMaxDiscount(0.1);
    product.setStockQuantity(10);

    return product;
  }

}
