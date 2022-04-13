package br.com.mentorama.movies.services;

import br.com.mentorama.movies.entities.Movie;
import br.com.mentorama.movies.exceptions.MovieRatingOutOfRangeException;
import br.com.mentorama.movies.repositories.MovieRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.mentorama.movies.utils.Constants.*;

@Service
@Log4j2
public class MovieService implements IMovieService {

  final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> findAll() {
    return movieRepository.findAll();
  }

  public Movie findById(Integer id) {
    return movieRepository.findById(id);
  }

  public void add(Movie movie) {
    movieRepository.setId(movie);
    movieRatingScale(movie);
    movieRepository.add(movie);
  }

  public void update(Movie movie) {
    movieRatingScale(movie);
    movieRepository.update(movie);
  }

  public void delete(Integer id) {
    movieRepository.delete(id);
  }

  private void movieRatingScale(Movie movie) {
    if (movie.getRating() < 1 || movie.getRating() > 5) {
      log.info("Nota atribuída ao filme:: {}", movie.getRating());
      log.error(ERROR_MOVIE_RATING);

      throw new MovieRatingOutOfRangeException(ERROR_MOVIE_RATING);
    }
  }

}
