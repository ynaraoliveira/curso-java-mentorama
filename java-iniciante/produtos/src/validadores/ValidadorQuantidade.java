package validadores;

import models.PedidoVenda;

public class ValidadorQuantidade implements IValidadorPedidoVenda{

  @Override
  public String validar(PedidoVenda pedidoVenda) {
    int quantidadeEstoque = pedidoVenda.getEstoque().getQuantidade();
    int quantidadePedido = pedidoVenda.getQuantidade();

    if (quantidadePedido > quantidadeEstoque) {
      return "Quantidade indisponível no estoque.";
    }

    return null;
  }
}
