package br.com.mentorama.movies.exceptions;

public class MovieAlreadyExistsException extends RuntimeException{

  public MovieAlreadyExistsException(String message) {
    super(message);
  }
}
