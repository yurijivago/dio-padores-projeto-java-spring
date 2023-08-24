package com.yurijivago.diopadoresprojetojavaspring.service;

import com.yurijivago.diopadoresprojetojavaspring.model.Cliente;
/*
* Interface utilizada para definir o padrão Strategy do domínio de Cliente.
* */
public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);

}
