package com.yurijivago.diopadoresprojetojavaspring.repository;

import com.yurijivago.diopadoresprojetojavaspring.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
