package models;

public class Carro {

    public static String VERMELHO = "vermelho";
    private Integer qtdePneus;
    private Integer qtdeCalotas;
    private Integer qtdeParafusosPneu;
    private Integer numPortas;
    private String numChassi;
    private Integer anoFabricacao;
    private String tipoCombustivel;


    public Carro(Integer qtdePneus, Integer numPortas, String numChassi,
                 Integer anoFabricacao, String tipoCombustivel) {
        setQtdePneus(qtdePneus);
        setNumPortas(numPortas);
        setNumChassi(numChassi);
        setAnoFabricacao(anoFabricacao);
        setTipoCombustivel(tipoCombustivel);
    }

    public void setCor(String cor) {
        System.out.println("Cor: " + cor);
    }

    public void setQtdePneus(Integer qtdePneus) {
        setQtdeCalotas(qtdePneus);
        setQtdeParafusosPneu(qtdePneus * 4);
        this.qtdePneus = qtdePneus + 1;
    }

    public Integer getQtdePneus() {
        return qtdePneus;
    }

    public void setQtdeCalotas(Integer qtdeCalotas) {
        this.qtdeCalotas = qtdeCalotas;
    }

    public Integer getQtdeCalotas() {
        return qtdeCalotas;
    }

    public Integer getQtdeParafusosPneu() {
        return qtdeParafusosPneu;
    }

    public void setQtdeParafusosPneu(Integer qtdeParafusosPneu) {
        this.qtdeParafusosPneu = qtdeParafusosPneu;
    }

    public void setNumPortas(Integer numPortas) {
        this.numPortas = numPortas;
    }

    public Integer getNumPortas() {
        return numPortas;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void imprimeValores() {
        System.out.println("Quantidade de pneus: " + getQtdePneus());
        System.out.println("Quantidade de calotas: " + getQtdeCalotas());
        System.out.println("Quantidade de parafusos: " + getQtdeParafusosPneu());
        System.out.println("Número de portas: " + getNumPortas());
        System.out.println("Número do chassi: " + getNumChassi());
        System.out.println("Ano de fabricação: " + getAnoFabricacao());
        System.out.println("Tipo de combustível: " + getTipoCombustivel());
    }

}
