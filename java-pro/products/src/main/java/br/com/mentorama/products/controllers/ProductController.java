package br.com.mentorama.products.controllers;

import br.com.mentorama.products.models.Product;
import br.com.mentorama.products.models.SalesRequestDTO;
import br.com.mentorama.products.models.SalesResponseDTO;
import br.com.mentorama.products.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

  final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public Product findById(@PathVariable("id") UUID id) {
      return productService.findById(id);
  }

  @PostMapping
  public ResponseEntity add(@RequestBody Product product) {
    productService.add(product);
    return new ResponseEntity("Produto criado com sucesso.", HttpStatus.CREATED);
  }

  @PostMapping("/sell")
  public SalesResponseDTO sellProducts(@RequestBody SalesRequestDTO salesRequestDTO) {
    return productService.sellProducts(salesRequestDTO);
  }
}
