package br.com.mentorama.movies.exceptions;

public class MovieRatingOutOfRangeException extends RuntimeException{
  public MovieRatingOutOfRangeException(String message) {
    super(message);
  }
}
