package br.com.mentorama.movies.services;

import br.com.mentorama.movies.entities.Movie;

import java.util.List;

public interface IMovieService {

  List<Movie> findAll();
  Movie findById(Integer id);
  void add(Movie movie);
  void update(Movie movie);
  void delete(Integer id);
}
