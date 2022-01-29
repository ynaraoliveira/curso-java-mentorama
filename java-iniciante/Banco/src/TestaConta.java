import db.ClientesDB;
import db.ContasDB;
import models.*;

import java.text.ParseException;
import java.util.Scanner;

public class TestaConta {

  static ClientesDB clientesDB = new ClientesDB();
  static ContasDB contasDB = new ContasDB();

  public static void main(String[] args) throws Exception {

    int opcao;

    do {
      System.out.println("Opção 1: Cadastrar cliente");
      System.out.println("Opção 2: Cadastrar conta corrente");
      System.out.println("Opção 3: Cadastrar conta poupança");
      System.out.println("Opção 4: Cadastrar conta salário");
      System.out.println("Opção 5: Listar contas");
      System.out.println("Opção 6: Transferir saldo entre contas");
      System.out.println("Opção 7: Exibir saldo total do banco");
      System.out.println("Opção 8: Listar clientes");
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
        String id = sc.nextLine();
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
          System.out.println(conta.toString());
          System.out.println("---------------------------------");
        }
        break;
      }

      case 6: {
        System.out.println("---------------- TRANSFERÊNCIA ENTRE CONTAS ----------------");
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o valor da transferência? ");
        double valor = sc.nextDouble();
        System.out.println("Qual a agência da conta a receber? ");
        int agenciaAReceber = sc.nextInt();
        System.out.println("Qual a agência da conta a debitar? ");
        int agenciaADebitar = sc.nextInt();

        Conta contaADebitar = contasDB.getContaPorAgencia(agenciaAReceber);
        Conta contaAReceber = contasDB.getContaPorAgencia(agenciaADebitar);
        contaADebitar.transferir(contaAReceber, contaADebitar, valor);
        System.out.println("Saldo da conta " + contaAReceber.getCliente() + " " + contaAReceber.getSaldo());
        System.out.println("Saldo da conta " + contaADebitar.getCliente() + " " + contaADebitar.getSaldo());

        break;
      }

      case 7: {
        System.out.println("---------------- SALDO TOTAL DO BANCO ----------------");
        double saldoTotal = 0;

        for(Conta conta : contasDB.getContas()) {
          saldoTotal += conta.getSaldo();
        }
        System.out.println("O saldo total do banco é R$" + saldoTotal);
        break;
      }

      case 8: {
        System.out.println("---------------- LISTA DE CLIENTES CADASTRADAS ----------------");

        for(Cliente cliente : clientesDB.getClientesList()) {
          System.out.println(cliente.toString());
          System.out.println("---------------------------------");
        }
        break;
      }

    }
  }
}
