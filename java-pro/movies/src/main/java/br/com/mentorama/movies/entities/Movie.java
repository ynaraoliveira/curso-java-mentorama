package br.com.mentorama.movies.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

  private Integer id;
  private String movieTitle;
  private String director;
  private Integer releaseYear;
  private Integer rating;
}
