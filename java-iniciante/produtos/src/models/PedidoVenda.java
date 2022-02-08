package models;

import java.text.DecimalFormat;

public class PedidoVenda {

  private int id;
  private Cliente cliente;
  private Estoque estoque;
  private int quantidade;

  public PedidoVenda(Cliente cliente, Estoque estoque, int quantidade) {
    this.cliente = cliente;
    this.estoque = estoque;
    this.quantidade = quantidade;
  }

//  public String getValorTotal() {
//    DecimalFormat df = new DecimalFormat("#.00");
//    return df.format(quantidade * estoque.getPreco());
//  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Estoque getEstoque() {
    return estoque;
  }

  public void setEstoque(Estoque estoque) {
    this.estoque = estoque;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
}
