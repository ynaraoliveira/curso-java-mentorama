import db.ClientesDB;
import db.ContasDB;
import models.*;

import java.text.ParseException;
import java.util.Scanner;

public class TestaConta {

  static ClientesDB clientesDB = new ClientesDB();
  static ContasDB contasDB = new ContasDB();

  public static void main(String[] args) throws Exception {

//    ContaCorrente cc1 = new ContaCorrente(1, 123, "models.Banco Roxo", 100, 200);
//
//    System.out.println("--------------------- CONTA CORRENTE ---------------------");
//    System.out.println(cc1);
//    cc1.sacar(10);
//    System.out.println("O saldo da conta corrente é R$" + cc1.getSaldo());
//    cc1.sacar(18.5);
//    System.out.println("O saldo da conta corrente é R$" + cc1.getSaldo());
//    cc1.depositar(10);
//    System.out.println("O saldo da conta corrente é R$" + cc1.getSaldo());
//    System.out.println("A taxa de imposto é " + cc1.getValorImposto());
//
//    ContaPoupanca cp1 = new ContaPoupanca(2, 456, "models.Banco Roxo", 5000, 1.06, new Cliente(1, "Ana"));
//
//    System.out.println("--------------------- CONTA POUPANÇA ---------------------");
//    System.out.println(cp1);
//    cp1.rendimentoAnual();
//    System.out.println("O saldo da conta poupança é R$" + cp1.getSaldo());
//    cp1.sacar(1000);
//    System.out.println("O saldo da conta poupança após saque é R$" + cp1.getSaldo());
//    cp1.depositar(500);
//    System.out.println("O saldo da conta poupança após depósito é R$" + cp1.getSaldo());
//
//    ContaSalario cs1 = new ContaSalario(3, 789, "models.Banco Roxo", 3000);
//
//    System.out.println("--------------------- CONTA SALÁRIO ---------------------");
//    System.out.println(cs1);
//    cs1.sacar(100);
//    System.out.println("O saldo da conta poupança após saque é R$" + cs1.getSaldo());
//    cs1.sacar(200);
//    System.out.println("O saldo da conta poupança após saque é R$" + cs1.getSaldo());
////    RN: terceiro saque nao vai funcionar
//    cs1.sacar(300);
//    System.out.println(cs1.getValorImposto());
//
////    teste de transferencia
//    cs1.transferir(cp1, cs1, 10);
//    System.out.println(cs1.getSaldo());
//    System.out.println(cp1.getSaldo());
//
////    solução do prof
//    Conta contas[] = new Conta[3];
//    contas[0] = cc1;
//    contas[1] = cp1;
//    contas[2] = cs1;
//
//    System.out.println("Obtendo o saldo das contas:");
//    for (Conta conta:contas) {
//      System.out.println(conta);
//      System.out.println("Saldo atual: R$" + conta.getSaldo());
//      System.out.println("--------------");
//    }

    int opcao;

    do {
      System.out.println("Opção 1: Cadastrar usuário");
      System.out.println("Opção 2: Cadastrar conta corrente");
      System.out.println("Opção 3: Cadastrar conta poupança");
      System.out.println("Opção 4: Cadastrar conta salário");
      System.out.println("Opção 5: Listar contas");
      System.out.println("Opção 6: Transferir saldo entre contas");
      System.out.println("Opção 7: Exibir saldo total do banco");
      System.out.println("Opção 0: Sair");

      System.out.println("Qual opcão você deseja?");

      Scanner sc = new Scanner(System.in);
      opcao = sc.nextInt();

      processa(opcao);
    } while (opcao != 0);

  }

  private static void processa(int opcao) throws ParseException {

    switch (opcao) {
      case 1: {
        System.out.println("CADASTRAR NOVO USUÁRIO");
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o id do cliente? ");
        String id = sc.next();
        System.out.println("Qual o nome do cliente? ");
        String nome = sc.nextLine();

        Cliente cliente = new Cliente(id, nome);
        clientesDB.addNovoCliente(cliente);

        break;
      }

      case 2: {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o id do cliente? ");
        int id = sc.nextInt();

        System.out.println("Qual o número da conta? ");
        int numero = sc.nextInt();

        System.out.println("Qual o número da agência? ");
        int agencia = sc.nextInt();

        System.out.println("Qual o código do banco? ");
        int banco = sc.nextInt();

        System.out.println("Qual o saldo inicial? ");
        double saldo = sc.nextDouble();

        System.out.println("Qual o valor do cheque especial? ");
        double chequeEspecial = sc.nextDouble();

        Cliente cliente = clientesDB.getClientePorId(id);
        System.out.println("Id do cliente: " + cliente.getId());
        System.out.println("Nome do cliente: " + cliente.getNome());

        Conta contaCorrente = new ContaCorrente(numero, agencia, banco, saldo, chequeEspecial, cliente);
        contasDB.addNovaConta(contaCorrente);

        break;
      }

      case 3: {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o id do cliente? ");
        int id = sc.nextInt();

        System.out.println("Qual o número da conta? ");
        int numero = sc.nextInt();

        System.out.println("Qual o número da agência? ");
        int agencia = sc.nextInt();

        System.out.println("Qual o código do banco? ");
        int banco = sc.nextInt();

        System.out.println("Qual o saldo inicial? ");
        double saldo = sc.nextDouble();

        System.out.println("Qual o valor da taxa de rendimento? ");
        double juros = sc.nextDouble();

        Cliente cliente = clientesDB.getClientePorId(id);
        System.out.println("Id do cliente: " + cliente.getId());
        System.out.println("Nome do cliente: " + cliente.getNome());

        Conta contaPoupanca = new ContaPoupanca(numero, agencia, banco, saldo, juros, cliente);
        contasDB.addNovaConta(contaPoupanca);

        break;
      }

      case 4: {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o id do cliente? ");
        int id = sc.nextInt();

        System.out.println("Qual o número da conta? ");
        int numero = sc.nextInt();

        System.out.println("Qual o número da agência? ");
        int agencia = sc.nextInt();

        System.out.println("Qual o código do banco? ");
        int banco = sc.nextInt();

        System.out.println("Qual o saldo inicial? ");
        double saldo = sc.nextDouble();

        Cliente cliente = clientesDB.getClientePorId(id);
        System.out.println("Id do cliente: " + cliente.getId());
        System.out.println("Nome do cliente: " + cliente.getNome());

        Conta contaSalario = new ContaSalario(numero, agencia, banco, saldo, cliente);
        contasDB.addNovaConta(contaSalario);

        break;
      }

      case 5: {
        System.out.println("---------------- LISTA DE CONTAS CADASTRADAS ----------------");

        for(Conta conta : contasDB.getContas()) {
          System.out.println("---------------------------------");
          System.out.println(conta.toString());
        }
        break;
      }
    }
  }
}
