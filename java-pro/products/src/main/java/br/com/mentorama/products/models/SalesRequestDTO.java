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
public class SalesRequestDTO {

  private UUID id;
  private Integer quantity;
  private Double discount;
}
