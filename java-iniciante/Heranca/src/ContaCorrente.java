public class ContaCorrente extends Conta {

  private double chequeEspecial;
  private double taxaSaque = 1.5;

  public ContaCorrente(int numero, int agencia, String banco, double saldo, double chequeEspecial) {
    super(numero, agencia, banco, saldo);
    this.chequeEspecial = chequeEspecial;
  }

  @Override
  public void sacar(double valor) {

    if(valor == super.saldo) {
      processarSaque(valor);
      System.out.println("Você está no cheque especial.");
    } else if (valor == super.saldo + this.chequeEspecial) {
      processarSaque(valor);
      System.out.println("Você já usou o limite do seu cheque especial");
    } else if (valor < super.saldo + this.chequeEspecial) {
      processarSaque(valor);
    } else {
      System.out.println("Não foi possível processar a transação. Verifique o seu saldo.");
    }
  }

  private void processarSaque(double valor) {
    double novoSaldo = super.saldo - valor - taxaSaque;
    super.setSaldo(novoSaldo);
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
            ", banco " + super.getBanco() + ", saldo R$" + getSaldo() + ", cheque especial R$" + chequeEspecial;
  }
}

