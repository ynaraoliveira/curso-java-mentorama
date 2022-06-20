package br.com.mentorama.products.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesRequestDTO {

  private Integer id;
  private Integer quantity;
  private Double discount;
}
