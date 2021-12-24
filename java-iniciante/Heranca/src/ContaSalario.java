public class ContaSalario extends Conta {

  private int limiteSaque = 2;
  private int count = 0;

  public ContaSalario(int numero, int agencia, String banco, double saldo) {
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
  public String toString() {
    return "Conta corrente:: agência " + super.getAgencia() + ", número " + super.getNumero() +
            ", banco " + super.getBanco() + ", saldo R$" + getSaldo() + ", limite de saques " + limiteSaque;
  }
}
