public abstract class Conta {

  private int numero;
  private int agencia;
  private String banco;
  protected double saldo;

  public Conta(int numero, int agencia, String banco, double saldo) {
    this.numero = numero;
    this.agencia = agencia;
    this.banco = banco;
    this.saldo = saldo;
  }

  public abstract void sacar(double valor);

  public abstract void depositar(double valor);

  public int getNumero() {
    return numero;
  }

  public int getAgencia() {
    return agencia;
  }

  public String getBanco() {
    return banco;
  }

  public abstract double getSaldo();

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public abstract String toString();
}
