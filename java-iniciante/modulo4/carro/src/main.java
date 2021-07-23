import models.Carro;

public class main {

    public static void main(String[] args) {

        Carro carro = new Carro(4, 4, "1J82K932KDF949",
                2018, "flex");
        carro.setCor(Carro.VERMELHO);

        System.out.println("-------- DADOS DO CARRO --------");
        carro.imprimeValores();

    }

}
