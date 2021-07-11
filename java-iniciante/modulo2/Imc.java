import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Imc {
  public static void main(String[] args) {

    System.out.println("------ Calculadora IMC ------");

    Scanner sc = new Scanner(System.in);
    NumberFormat formatter = new DecimalFormat("#0.00");

    double imc = 0;

    try {
      System.out.println("Qual o seu peso em kilos?");
      double peso = sc.nextDouble();

      System.out.println("Qual a sua altura em metros?");
      double altura = sc.nextDouble();

      imc = peso / Math.pow(altura, 2);

    } catch (InputMismatchException ex) {
      throw new InputMismatchException();
    }

    String resultadoImc;

    if (imc < 18.5) {
      resultadoImc = "magreza";
    } else if (imc >= 18.5 && imc < 24.9) {
      resultadoImc = "normalidade";
    } else if (imc >= 24.9 && imc < 30) {
      resultadoImc = "sobrepeso";
    } else {
      resultadoImc = "obesidade";
    }

    System.out.println("O seu IMC é " + formatter.format(imc) + ", o que indica " + resultadoImc);

    sc.close();

  }
}
