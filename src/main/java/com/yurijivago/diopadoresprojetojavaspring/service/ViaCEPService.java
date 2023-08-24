package com.yurijivago.diopadoresprojetojavaspring.service;

import com.yurijivago.diopadoresprojetojavaspring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
* Cliente HTTP criado via OpenFeign para o consumo da API do ViaCEP
*
* @see <a href="https://viacep.com.br/">ViaCEP</a>
* */
@FeignClient(name = "viacep", url ="https://viacep.com.br/ws")
public interface ViaCEPService {
    @GetMapping("/{cep}/json/")
    Endereco consultaCep(@PathVariable("cep") String cep);
}
