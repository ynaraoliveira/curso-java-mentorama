package br.com.mentorama.products.exceptions;

import br.com.mentorama.products.models.Product;
import br.com.mentorama.products.models.SalesRequestDTO;
import br.com.mentorama.products.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static br.com.mentorama.products.utils.Constants.PRODUCT_OUT_OF_STOCK_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ExceptionsTest {

  @Autowired
  ProductService productService;

  @Test
  public void shouldThrowProductOutOfStockException() {
    Product product = generateProductOutOfStock();
    productService.add(product);

    SalesRequestDTO salesRequestDTO = new SalesRequestDTO(1, 1, 0.05);

    ProductOutOfStockException exception = assertThrows(ProductOutOfStockException.class,
            () -> productService.setFinalProductQuantity(salesRequestDTO));
    assertEquals(PRODUCT_OUT_OF_STOCK_MESSAGE, exception.getMessage());
  }

  private Product generateProductOutOfStock() {
    Product product = new Product();
    product.setId(1);
    product.setDescription("tv");
    product.setPrice(100.00);
    product.setMaxDiscount(0.1);
    product.setStockQuantity(0);

    return product;
  }
}
