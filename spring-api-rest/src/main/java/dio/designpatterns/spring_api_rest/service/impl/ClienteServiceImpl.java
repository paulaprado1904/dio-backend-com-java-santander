package dio.designpatterns.spring_api_rest.service.impl;

import dio.designpatterns.spring_api_rest.model.Cliente;
import dio.designpatterns.spring_api_rest.model.ClienteRepository;
import dio.designpatterns.spring_api_rest.model.Endereco;
import dio.designpatterns.spring_api_rest.model.EnderecoRepository;
import dio.designpatterns.spring_api_rest.service.ClienteService;
import dio.designpatterns.spring_api_rest.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscaporId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        //Verificar se o Endereço do Cliente já existe (pelo CEP)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            //Caso não exista, integrar com o ViaCep e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}


