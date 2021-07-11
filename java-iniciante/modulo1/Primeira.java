import java.util.Scanner;

class Primeira {
  public static void main(String[] args) {
    // System.out.println("oi mundo");

    Scanner sc = new Scanner(System.in);

    System.out.println("Qual o seu nome?");
    String nome = sc.next();
    System.out.println("Olá " + nome);

    sc.close();
  }
}