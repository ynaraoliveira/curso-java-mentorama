package db;

import models.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientesDB {

  private Map<String, Cliente> clientesMap = new HashMap<>();

  public List<Cliente> getClientesList() {
    List<Cliente> clientes = new ArrayList<>();

    for(Map.Entry<String, Cliente> cliente : clientesMap.entrySet()) {
      clientes.add(cliente.getValue());
    }
    return clientes;
  }

  public void addNovoCliente(Cliente cliente) {
    clientesMap.put(cliente.getId(), cliente);
  }

  public Cliente getClientePorId(int id) {
    return clientesMap.get(id);
  }

}
