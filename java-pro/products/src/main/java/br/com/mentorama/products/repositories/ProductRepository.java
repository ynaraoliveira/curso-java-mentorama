package br.com.mentorama.products.repositories;

import br.com.mentorama.products.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {

  private final List<Product> productList;

  public ProductRepository(List<Product> productList) {
    this.productList = productList;
  }

  public List<Product> findAll() {
    return productList;
  }

  public Product findById(UUID id) {
    return productList.stream()
            .filter(pd -> pd.getId().equals(id))
            .findFirst()
            .orElse(null);
  }

  public void add(Product product) {
    productList.add(product);
  }

  public void setId(Product product) {
    product.setId(UUID.randomUUID());
  }

}
