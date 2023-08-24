package com.yurijivago.diopadoresprojetojavaspring.service.impl;

import com.yurijivago.diopadoresprojetojavaspring.model.Cliente;
import com.yurijivago.diopadoresprojetojavaspring.model.Endereco;
import com.yurijivago.diopadoresprojetojavaspring.repository.ClienteRepository;
import com.yurijivago.diopadoresprojetojavaspring.repository.EnderecoRepository;
import com.yurijivago.diopadoresprojetojavaspring.service.ClienteService;
import com.yurijivago.diopadoresprojetojavaspring.service.ViaCEPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    //Singleton: Injetar os componentes do Spring
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCEPService viaCEPService;
    //Strategy: Implementar os métodos definidos na interface
    //Facade: Abstrair integrações com subsistemas, provendo interface simples
    @Override
    public Iterable<Cliente> buscarTodos() {
        //Buscar todos os clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        //Buscar Cliente por ID
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComEndereco(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteDb = clienteRepository.findById(id);
        if(clienteDb.isPresent()){
            //Verificar se o Endereço do Cliente já existe (pelo CEP)
            //Caso não exista, integrar com o ViaCEP e persistir o retorno
            //Alterar Cliente, vinculando o Endereço (novo ou existente)
            salvarClienteComEndereco(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        //Deletar o Cliente pelo ID
        clienteRepository.deleteById(id);
    }

    //métodos auxiliares
    private void salvarClienteComEndereco(Cliente cliente) {
        //Verificar se o Endereco do Cliente já existe, verificando o CEP
        // e caso não exista, integrar com o ViaCEP e persistir o retorno
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(
                () -> {
                    Endereco novoEndereco = viaCEPService.consultaCep(cep);
                    enderecoRepository.save(novoEndereco);
                    System.out.println("Novo Endereço!!!");
                    return novoEndereco;
                }
        );
        cliente.setEndereco(endereco);

        //Inserir Cliente, vinculando o Endereço (novo ou existente)
        clienteRepository.save(cliente);
    }
}