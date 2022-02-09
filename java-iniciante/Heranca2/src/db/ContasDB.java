package db;

import models.Conta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContasDB {

  private Map<Integer, Conta> contasDBMap = new HashMap<>();

  public List<Conta> getContas() {
    List<Conta> contas = new ArrayList<>();

    for(Map.Entry<Integer, Conta> conta : contasDBMap.entrySet()) {
      contas.add(conta.getValue());
    }
    return contas;
  }

  public void addNovaConta(Conta conta) {
    contasDBMap.put(conta.getNumero(), conta);
  }

  public Conta getContaPorAgencia(int agencia) {
  return contasDBMap.get(agencia);
  }

}
