public class TestaConta {

  public static void main(String[] args) {

    ContaCorrente cc1 = new ContaCorrente(1, 123, "Banco Roxo", 100, 200);

    System.out.println("--------------------- CONTA CORRENTE ---------------------");
    System.out.println(cc1);
    cc1.sacar(10);
    System.out.println("O saldo da conta corrente é R$" + cc1.getSaldo());
    cc1.sacar(288.5);
    System.out.println("O saldo da conta corrente é R$" + cc1.getSaldo());
    cc1.depositar(10);
    System.out.println("O saldo da conta corrente é R$" + cc1.getSaldo());

    ContaPoupanca cp1 = new ContaPoupanca(2, 456, "Banco Laranja", 5000, 1.06);

    System.out.println("--------------------- CONTA POUPANÇA ---------------------");
    System.out.println(cp1);
    cp1.rendimentoAnual();
    System.out.println("O saldo da conta poupança é R$" + cp1.getSaldo());
    cp1.sacar(1000);
    System.out.println("O saldo da conta poupança após saque é R$" + cp1.getSaldo());
    cp1.depositar(500);
    System.out.println("O saldo da conta poupança após depósito é R$" + cp1.getSaldo());

    ContaSalario cs1 = new ContaSalario(3, 789, "Banco Vermelho", 3000);

    System.out.println("--------------------- CONTA SALÁRIO ---------------------");
    System.out.println(cs1);
    cs1.sacar(100);
    System.out.println("O saldo da conta poupança após saque é R$" + cs1.getSaldo());
    cs1.sacar(200);
    System.out.println("O saldo da conta poupança após saque é R$" + cs1.getSaldo());
    cs1.sacar(300);
  }
}
