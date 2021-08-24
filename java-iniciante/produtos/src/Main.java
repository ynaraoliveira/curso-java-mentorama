import models.Produto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {

    System.out.println("--- PEDIDO DE VENDAS ---");

    int option;

    do {
      System.out.println("--- Opção 1: Cadastrar novo produto");
      System.out.println("--- Opção 0: Sair");

      Scanner scanner = new Scanner(System.in);

      System.out.print("Qual operação você deseja realizar? ");
      option = scanner.nextInt();

      process(option);
    } while (option != 0);
  }

  public static void process(int option) throws ParseException {
    switch (option) {
      case 1: {
        System.out.print("Qual descrição você deseja dar ao novo produto? ");
        Scanner scanner = new Scanner(System.in);
        String descricao = scanner.nextLine();

        System.out.print("Qual ID você deseja dar ao produto? ");
        int id = scanner.nextInt();

        System.out.print("Qual o preço do produto? ");
        double preco = scanner.nextDouble();

        System.out.print("Qual a data de validade do produto? ");
        String dataString = scanner.next();

        Date dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

        Produto novoProduto = new Produto(id, descricao, preco, dataValidade);

        System.out.println("Novo produto criado com sucesso");
        System.out.println("--- ID: " + novoProduto.getId());
        System.out.println("--- Descrição: " + novoProduto.getDescricao());
        System.out.println("--- Preço: " + novoProduto.getPreco());
        System.out.println("--- Dara de Validade: " + novoProduto.getDataValidade());

      }
    }
  }
}



