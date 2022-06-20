package br.com.mentorama.products.services;

import br.com.mentorama.products.exceptions.ProductOutOfStockException;
import br.com.mentorama.products.models.Product;
import br.com.mentorama.products.models.SalesRequestDTO;
import br.com.mentorama.products.models.SalesResponseDTO;
import br.com.mentorama.products.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.mentorama.products.utils.Constants.*;

@Service
@Log4j2
public class ProductService {

  final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(Integer id) {
    return productRepository.findById(id);
  }

  public void add(Product product) {
    productRepository.setId(product);
    productRepository.add(product);
  }

  public SalesResponseDTO sellProducts(SalesRequestDTO salesOrder) {
    setFinalDiscount(salesOrder);
    setFinalProductQuantity(salesOrder);
    Double finaPrice = calcaulateFinalPrice(salesOrder);

    SalesResponseDTO salesResponseDTO = new SalesResponseDTO();
    salesResponseDTO.setFinalPrice(finaPrice);
    return salesResponseDTO;
  }

  public void setFinalDiscount(SalesRequestDTO salesRequestDTO) {
    Product productInStock = findById(salesRequestDTO.getId());

    if (salesRequestDTO.getDiscount() > productInStock.getMaxDiscount()) {
      salesRequestDTO.setDiscount(productInStock.getMaxDiscount());
    }
  }

  public void setFinalProductQuantity(SalesRequestDTO salesRequestDTO) {
    Product productInStock = findById(salesRequestDTO.getId());

    if (productInStock.getStockQuantity().equals(0)) {
      log.error(PRODUCT_OUT_OF_STOCK_MESSAGE);
      throw new ProductOutOfStockException(PRODUCT_OUT_OF_STOCK_MESSAGE);
    }

    if (salesRequestDTO.getQuantity() > productInStock.getStockQuantity()) {
      salesRequestDTO.setQuantity(productInStock.getStockQuantity());
    }

    productInStock.setStockQuantity(productInStock.getStockQuantity() - salesRequestDTO.getQuantity());
  }

  public Double calcaulateFinalPrice(SalesRequestDTO salesRequestDTO) {
    Product productInStock = findById(salesRequestDTO.getId());
    return salesRequestDTO.getQuantity() * (productInStock.getPrice() - (productInStock.getPrice() * salesRequestDTO.getDiscount()));
  }

}
