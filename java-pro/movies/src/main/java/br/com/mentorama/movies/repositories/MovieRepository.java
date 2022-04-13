package br.com.mentorama.movies.repositories;

import br.com.mentorama.movies.entities.Movie;
import br.com.mentorama.movies.exceptions.MovieAlreadyExistsException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

import static br.com.mentorama.movies.utils.Constants.*;

@Repository
@Log4j2
public class MovieRepository {

  private final List<Movie> moviesList;

  public MovieRepository(List<Movie> moviesList) {
    this.moviesList = moviesList;
  }

  public List<Movie> findAll() {
    return moviesList;
  }

  public Movie findById(Integer id) {
    return moviesList.stream()
            .filter(movie -> movie.getId().equals(id))
            .findFirst()
            .orElse(null);
  }

  public void add(Movie movie) {
    singleMovieRequirement(movie);
    moviesList.add(movie);
  }

  public void update(Movie movie) {
    Movie outdatedMovie = moviesList.stream()
            .filter(mv -> mv.getId().equals(movie.getId()))
            .findFirst()
            .orElse(null);

    assert outdatedMovie != null;
    outdatedMovie.setMovieTitle(movie.getMovieTitle());
    outdatedMovie.setDirector(movie.getDirector());
    outdatedMovie.setRating(movie.getRating());
    outdatedMovie.setReleaseYear(movie.getReleaseYear());
  }

  public void delete(Integer id) {
    moviesList.removeIf(movie -> movie.getId().equals(id));
  }

  public void setId(Movie movie) {
    movie.setId(moviesList.size() + 1);
  }

  private void singleMovieRequirement(Movie movie) {
    Boolean isRepeatedMovieTitle = moviesList.stream()
            .anyMatch(mv -> mv.getMovieTitle().equals(movie.getMovieTitle()));

    Boolean isRepeatedMovieDirector = moviesList.stream()
            .anyMatch(mv -> mv.getDirector().equals(movie.getDirector()));

    Boolean isRepeatedReleaseYear = moviesList.stream()
            .anyMatch(mv -> mv.getReleaseYear().equals(movie.getReleaseYear()));

    if (isRepeatedMovieTitle && isRepeatedMovieDirector) {
      if (isRepeatedReleaseYear) {
        log.error(ERROR_MOVIE_RATING);
        throw new MovieAlreadyExistsException(ERROR_MOVIE_ALREADY_EXISTS);
      }
    }
  }
}
