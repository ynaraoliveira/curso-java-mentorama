import db.EstoquesDB;
import db.ProdutosDB;
import db.UsuariosDB;
import models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

  static ProdutosDB produtosDB = new ProdutosDB();
  static UsuariosDB usuariosDB = new UsuariosDB();
  static EstoquesDB estoquesDB = new EstoquesDB();

  public static void main(String[] args) throws Exception {

    System.out.println("--- PEDIDO DE VENDAS ---");

    int option;

    do {
      System.out.println("--- Opção 1: Cadastrar novo produto");
      System.out.println("--- Opção 2: Listar produtos");
      System.out.println("--- Opção 3: Cadastrar usuário ADMINISTRADOR");
      System.out.println("--- Opção 4: Cadastrar usuário CLIENTE");
      System.out.println("--- Opção 5: Listar todos os usuários");
      System.out.println("--- Opção 6: Cadastrar novo estoque de produtos");
      System.out.println("--- Opção 7: Listar todos os estoques");
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
        produtosDB.addNovoProduto(novoProduto);

        break;
      }

      case 2: {
        List<Produto> listaDeProdutos = produtosDB.getProdutosList();
        System.out.println("------------ LISTA DE PRODUTOS ------------");

        for(Produto produto : listaDeProdutos) {
          System.out.println("---------------------------------------------------");
          System.out.println("--- ID: " + produto.getId());
          System.out.println("--- Descrição: " + produto.getDescricao());
          System.out.println("--- Preço: " + produto.getPreco());
          System.out.println("--- Dara de Validade: " + produto.getDataValidade());
        }

        break;
      }

      case 3: {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o nome do usuário ADMINISTRADOR? ");
        String nome = sc.nextLine();

        Admin novoAdmin = new Admin(nome);
        usuariosDB.addNovoUsuario(novoAdmin);
        break;
      }

      case 4: {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o nome do usuário CLIENTE? ");
        String nome = sc.nextLine();

        Cliente novoCliente = new Cliente(nome);
        usuariosDB.addNovoUsuario(novoCliente);
        break;
      }

      case 5: {
        System.out.println("------------ LISTA DE USUARIOS ------------");

        for(Usuario usuario : usuariosDB.getUsuarioList()) {
          System.out.println("---------------------------------------------------");
          System.out.println("ID: " + usuario.getId());
          System.out.println("USUARIO: " + usuario.getNome());
          System.out.println("TIPO DE USUARIO: " + usuario.getTipoUsuario());
        }
        break;
      }

      case 6: {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o identificador do estoque? ");
        String id = sc.next();

        System.out.print("Qual o id do produto que será adicionado ao estoque? ");
        int produtoId = sc.nextInt();

        Produto produto = produtosDB.getProdutoPorId(produtoId);
        System.out.println("PRODUTO ID: " + produto.getId());
        System.out.println("DESCRIÇÃO DO PRODUTO: " + produto.getDescricao());
        System.out.println("VALIDADE DO PRODUTO: " + produto.getDataValidade());

        System.out.print("Qual a quantidade de produtos a ser adicionada ao estoque? ");
        int quantidade = sc.nextInt();

        Estoque estoque = new Estoque(id, produto, quantidade);
        estoquesDB.addNovoEstoque(estoque);

        break;
      }

      case 7: {
        System.out.println("------------ LISTA DE ESTOQUES CADASTRADOS ------------");

        for(Estoque estoque : estoquesDB.getEstoques()) {
          System.out.println("---------------------------------------------------");
          System.out.println("ID: " + estoque.getId());
          System.out.println("PRODUTO: " + estoque.getProduto().getDescricao());
          System.out.println("PREÇO: " + estoque.getProduto().getPreco());
          System.out.println("QUANTIDADE: " + estoque.getQuantidade());
        }
        break;
      }
    }
  }
}



