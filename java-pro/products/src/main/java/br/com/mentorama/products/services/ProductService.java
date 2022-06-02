package br.com.mentorama.products.services;

import br.com.mentorama.products.exceptions.ProductOutOfStockException;
import br.com.mentorama.products.models.Product;
import br.com.mentorama.products.models.SalesRequestDTO;
import br.com.mentorama.products.models.SalesResponseDTO;
import br.com.mentorama.products.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

  public Product findById(UUID id) {
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

  private void setFinalDiscount(SalesRequestDTO salesRequestDTO) {
    Product productInStock = findById(salesRequestDTO.getId());

    if (salesRequestDTO.getDiscount() > productInStock.getMaxDiscount()) {
      salesRequestDTO.setDiscount(productInStock.getMaxDiscount());
    }
  }

  private void setFinalProductQuantity(SalesRequestDTO salesRequestDTO) {
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

  private Double calcaulateFinalPrice(SalesRequestDTO salesRequestDTO) {
    Product productInStock = findById(salesRequestDTO.getId());
    return salesRequestDTO.getQuantity() * (productInStock.getPrice() - (productInStock.getPrice() * salesRequestDTO.getDiscount()));
  }

//  TODO RN1: ao tentar dar um desconto maior que o permitido deve considerar o desconto max
//  TODO RN2: ao tentar vender mais que o disponível em estoque, vender a qtde disponível
//  TODO o endpoint de venda deve passar uma lista de items com código do produto, qtde e desconto
//  TODO o endpoint de venda deve retornar o valor total da compra
//  TODO validar RN com testes unitários
}
