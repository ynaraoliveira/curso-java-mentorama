import models.Cliente;
import models.ContaCorrente;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestaConta {

  public static void main(String[] args) {

    ContaCorrente cc1 = new ContaCorrente(1, 1, 180, 1200, 500);
    ContaCorrente cc2 = new ContaCorrente(2, 2, 190, 1500, 500);
    ContaCorrente cc3 = new ContaCorrente(3, 3, 200, 1800, 500);

    List<ContaCorrente> listaContaCorrente = Arrays.asList(cc1, cc2, cc3);

//    for(ContaCorrente conta:listaContaCorrente) {
//      System.out.println(conta);
//    }

    Cliente cliente1 = new Cliente("Carol", true, "abcd123", 10);
    Cliente cliente2 = new Cliente("Ana", true, "0987654", 30);
    Cliente cliente3 = new Cliente("Bruna", false, "h7sh7s", 50);
    Cliente cliente4 = new Cliente("Ynara", true, "qwerty", 120);
    Cliente cliente5 = new Cliente("Ju", true, "mnbvcx", 5);
    Cliente cliente6 = new Cliente("Pat", true, "123qwe", 8);
    Cliente cliente7 = new Cliente("Lixolas", false, "asdmnb", 3);
    Cliente cliente8 = new Cliente("Guilherme", true, "098765", 25);
    Cliente cliente9 = new Cliente("Davi", true, "ygygyg", 15);
    Cliente cliente10 = new Cliente("Van", false, "zxcpoi", 34);

//    cliente1.autentica("abc123");

    List<Cliente> clientes = Arrays.asList(cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8, cliente9, cliente10);
    System.out.println("------------------ LISTA DE CLIENTES ------------------");
    for (Cliente cliente : clientes) {
      System.out.println(cliente.toString());
    }

//    clientes.forEach((cliente) -> System.out.println(cliente.getNome()));
//    clientes.forEach(Cliente::getNome);

//    for(Cliente cliente:clientes) {
//      System.out.println(cliente);
//    }
//    clientes.forEach(cliente -> System.out.println(cliente.getCompras()));
//    Stream<Cliente> stream = clientes.stream().filter(cliente -> cliente.getCompras() > 10);

    System.out.println("------------------ CLIENTE COM MAIS COMPRAS ------------------");
    System.out.println(clientes.stream().max(Comparator.comparing(Cliente::getCompras)).get());

    System.out.println("------------------ CLIENTE COM MENOS COMPRAS ------------------");
    System.out.println(clientes.stream().min(Comparator.comparing(Cliente::getCompras)).get());

    System.out.println("-------------------- MÉDIA DE COMPRAS --------------------");
    System.out.println(clientes.stream().mapToInt(Cliente::getCompras).average().getAsDouble());

//    List<Cliente> selecionados = stream.collect(Collectors.toList());
//    selecionados.forEach(cliente -> System.out.println(cliente.getCompras()));

  }

}
