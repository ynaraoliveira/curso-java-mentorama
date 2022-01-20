package models;

public abstract class Conta {

  private int numero;
  private int agencia;
  private int banco;
  protected double saldo;
  private Cliente cliente;

  public Conta(int numero, int agencia, int banco, double saldo, Cliente cliente) {
    this.numero = numero;
    this.agencia = agencia;
    this.banco = banco;
    this.saldo = saldo;
    this.cliente = cliente;
  }

  public abstract void sacar(double valor);

  public abstract void depositar(double valor);

  public void transferir(Conta contaAReceber, Conta contaADebitar, double valor) {
    contaADebitar.setSaldo(contaADebitar.saldo - valor);
    contaAReceber.setSaldo(contaAReceber.saldo + valor);
  }

  public int getNumero() {
    return numero;
  }

  public int getAgencia() {
    return agencia;
  }

  public int getBanco() {
    return banco;
  }

  public abstract double getSaldo();

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public abstract String toString();
}
