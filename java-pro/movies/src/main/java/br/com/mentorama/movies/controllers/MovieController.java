package br.com.mentorama.movies.controllers;

import br.com.mentorama.movies.entities.Movie;
import br.com.mentorama.movies.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

  final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public List<Movie> findAll() {
    return movieService.findAll();
  }

  @GetMapping("/{id}")
  public Movie findById(@PathVariable("id") Integer id) {
    return movieService.findById(id);
  }

  @PostMapping
  public ResponseEntity add(@RequestBody Movie movie) {
    movieService.add(movie);
    return new ResponseEntity("Filme de id " + movie.getId() + " criado com sucesso.",
            HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity update(@RequestBody Movie movie) {
    movieService.update(movie);
    return new ResponseEntity("Filme de id " + movie.getId() + " atualizado com sucesso.",
            HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Integer id) {
    movieService.delete(id);
    return new ResponseEntity("Filme de id " + id + " deletado com sucesso.",
            HttpStatus.OK);
  }
}
