import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int menu = 0;

    try {
      do {
        System.out.println("|----------- MENU -----------|");
        System.out.println("| Opções:                    |");
        System.out.println("|         1. Opção 1         |");
        System.out.println("|         2. Opção 2         |");
        System.out.println("|         3. Sair            |");
        System.out.println("");
        System.out.println("Selecione uma opção:");
        menu = sc.nextInt();

        switch (menu) {
          case 1:
            System.out.println("Opção 1 selecionada");
            break;
          case 2:
            System.out.println("Opção 2 selecionada");
            break;
          case 3:
            System.out.println("Opção 3 selecionada");
            break;
          default:
            System.out.println("Seleção inválida");
            break;
        }
      } while (menu != 3);
    } catch (InputMismatchException ex) {
      System.out.println("Seleção inválida");
    }

    System.out.println("Programa encerrado");

    sc.close();

  }
}