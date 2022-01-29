package models;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

  private double juros;
  private LocalDate dataCriacaoConta = LocalDate.of(2020, 12, 23);

  public ContaPoupanca(int numero, int agencia, int banco, double saldo, double juros, Cliente cliente) {
    super(numero, agencia, banco, saldo, cliente);
    this.juros = juros;
  }

  @Override
  public void sacar(double valor) {
    double novoSaldo = super.saldo - valor;
    super.setSaldo(novoSaldo);
  }

  @Override
  public void depositar(double valor) {
    double novoSaldo = super.saldo + valor;
    super.setSaldo(novoSaldo);
  }

  public void rendimentoAnual() {
    if(LocalDate.now().getDayOfMonth() == dataCriacaoConta.getDayOfMonth()
            && LocalDate.now().getMonth().equals(dataCriacaoConta.getMonth())) {
      double saldoComJuros = this.saldo * this.juros;
      super.setSaldo(saldoComJuros);
      System.out.println("Taxa de juros aplicada. Saldo final R$" + saldoComJuros);
    }
  }

  @Override
  public double getSaldo() {
    return this.saldo;
  }

  @Override
  public String toString() {
    return "Conta poupança:: agência " + super.getAgencia() + ", número " + super.getNumero() +
            ", banco " + super.getBanco() + ", saldo R$" + getSaldo() + ", taxa de juros " + juros +
            ", id do cliente " + getCliente().getId() + ", nome do cliente " +  getCliente().getNome();
  }
}
