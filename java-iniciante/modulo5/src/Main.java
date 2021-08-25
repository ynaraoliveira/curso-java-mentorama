import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Long numAleatorio1 = Math.round(Math.random() * 10);
    Long numAleatorio2 = Math.round(Math.random() * 10);

    Boolean numerosSaoIguais = numAleatorio1.equals(numAleatorio2);

    System.out.println("Número 1: " + numAleatorio1);
    System.out.println("Número 2: " + numAleatorio2);
    System.out.println("Os números são iguais? " + numerosSaoIguais);

  }

}
