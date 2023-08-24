package com.yurijivago.diopadoresprojetojavaspring.service.impl;

import com.yurijivago.diopadoresprojetojavaspring.model.Cliente;
import com.yurijivago.diopadoresprojetojavaspring.service.ClienteService;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class ClienteServiceImpl implements ClienteService {
    //Singleton: Injetar os componentes do Spring
    //Strategy: Implementar os métodos definidos na interface
    //Facade: Abstrair integrações com subsistemas, provendo interface simples
    @Override
    public Iterable<Cliente> buscarTodos() {
        //Buscar todos os clientes
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        //Buscar Cliente por ID
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        //Verificar se o Endereco do Cliente já existe, verificando o CEP
        //Caso não exista, integrar com o ViaCEP e persistir o retorno
        //Inserir Cliente, vinculando o Endereço (novo ou existente)
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //Buscar Cliente por ID, caso exista:
        //Verificar se o Endereço do Cliente já existe (pelo CEP)
        //Caso não exista, integrar com o ViaCEP e persistir o retorno
        //Alterar Cliente, vinculando o Endereço (novo ou existente)
    }

    @Override
    public void deletar(Long id) {
        //Deletar o Cliente pelo ID
    }
}
