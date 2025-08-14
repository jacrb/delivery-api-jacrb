package com.deliverytech.delivery.service;

import java.util.List;
import java.util.Optional;

import com.deliverytech.delivery.models.Clientes;

public interface ClienteService {
    Clientes cadastrar(Clientes cliente);
    Clientes atualizar(Long id, Clientes clienteAtualizado);
    void ativarDesativar(Long id);
    List<Clientes> listarAtivos();
    Optional<Clientes> buscarPorId(Long id);
}
