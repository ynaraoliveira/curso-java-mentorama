package br.com.mentorama.products.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  private UUID id;
  private String description;
  private Double price;
  private Double maxDiscount;
  private Integer stockQuantity;
}
