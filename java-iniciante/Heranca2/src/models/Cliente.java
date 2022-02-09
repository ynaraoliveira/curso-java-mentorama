package models;

public class Cliente implements Autenticador {

  private String nome;
  private boolean status;
  private String senha;
  private int compras;

  public Cliente(String nome, boolean status, String senha, int compras) {
    this.nome = nome;
    this.status = status;
    this.senha = senha;
    this.compras = compras;
  }

  public String getNome() {
    System.out.println(this.nome);
    return nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public int getCompras() {
    return compras;
  }

  @Override
  public String toString() {
    return "Cliente:: " + "nome: " + nome + ", status: " + status
            + ", senha: " + senha
            + ", compras: " + compras;
  }

  @Override
  public boolean autentica(String senha) {
    if (!this.senha.equals(senha)) {
      System.out.println("Não autenticado!");
      return false;
    }
    else {
      System.out.println("Autenticado!");
      return true;
    }
  }
}
