package models;

public class ContaSalario extends Conta implements Tributavel {

  private int limiteSaque = 2;
  private int count = 0;
  private double taxaTributavel = 0.005;

  public ContaSalario(int numero, int agencia, int banco, double saldo) {
    super(numero, agencia, banco, saldo);
  }

  @Override
  public void sacar(double valor) {
    if(count < limiteSaque) {
      double novoSaldo = super.saldo - valor;
      super.setSaldo(novoSaldo);
      count++;
    } else {
      System.out.println("Não há mais saques disponíveis");
    }
  }

  @Override
  public void depositar(double valor) {
    double novoSaldo = super.saldo + valor;
    super.setSaldo(novoSaldo);
  }

  @Override
  public double getSaldo() {
    return this.saldo;
  }

  @Override
  public double getValorImposto() {
    return this.saldo * taxaTributavel;
  }

  @Override
  public String toString() {
    return "Conta salário:: agência " + super.getAgencia() + ", número " + super.getNumero() +
            ", banco " + super.getBanco() + ", saldo R$" + getSaldo() + ", limite de saques " + limiteSaque;
  }
}
