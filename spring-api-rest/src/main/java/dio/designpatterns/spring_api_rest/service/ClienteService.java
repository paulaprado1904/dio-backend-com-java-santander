package dio.designpatterns.spring_api_rest.service;

import dio.designpatterns.spring_api_rest.model.Cliente;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscaporId(Long id);
    void inserir(Cliente cliente);
    void atualizar (Long id, Cliente cliente);
    void deletar(Long id);


}
