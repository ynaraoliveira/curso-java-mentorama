package validadores;

import models.PedidoVenda;

import java.util.ArrayList;
import java.util.List;

public class ValidadorPedidoVenda extends Validador {

  private PedidoVenda pedidoVenda;
  public List<IValidadorPedidoVenda> validadorPedidoVendas = new ArrayList<>();

  public ValidadorPedidoVenda(PedidoVenda pedidoVenda) {
    this.pedidoVenda = pedidoVenda;
    this.validadorPedidoVendas.add(new ValidadorDataValidade());
    this.validadorPedidoVendas.add(new ValidadorQuantidade());
  }

  @Override
  public boolean ehValido() {
    for (IValidadorPedidoVenda validador : validadorPedidoVendas) {
      String erro = validador.validar(pedidoVenda);

      if (erro != null) {
        addErro(erro);
      }
    }
    return !(getErros().size() > 0);
  }
}
