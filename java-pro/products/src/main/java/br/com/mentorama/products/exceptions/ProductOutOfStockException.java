package br.com.mentorama.products.exceptions;

public class ProductOutOfStockException extends RuntimeException{

  public ProductOutOfStockException(String message) {
    super(message);
  }
}
