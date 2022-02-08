package db;

import models.PedidoVenda;

import java.util.ArrayList;
import java.util.List;

public class PedidoVendasDB {

  List<PedidoVenda> pedidoVendas = new ArrayList<>();

  public List<PedidoVenda> getPedidoVendas() {
    return pedidoVendas;
  }

  public void addNovoPedido(PedidoVenda novoPedido) {
    int id = pedidoVendas.size() + 1;
    novoPedido.setId(id);
    pedidoVendas.add(novoPedido);
  }
}
