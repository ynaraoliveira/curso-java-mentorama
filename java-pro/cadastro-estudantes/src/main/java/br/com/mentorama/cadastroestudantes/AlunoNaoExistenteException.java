package br.com.mentorama.cadastroestudantes;

import org.springframework.http.HttpStatus;

public class AlunoNaoExistenteException extends Exception{

  public AlunoNaoExistenteException(String message) {
    super(message);
  }
}
