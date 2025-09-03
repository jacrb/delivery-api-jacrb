package com.deliverytech.delivery.services;

import java.util.List;
import java.util.Optional;

import com.deliverytech.delivery.models.Produto;

public interface ProdutoService {
    Produto cadastrar(Produto produto);
    Produto atualizar(Long id, Produto produtoAtuzalizado);
    Optional<Produto> buscarPorId(Long id);
    void alterarDisponibilidade(Long id, boolean disponivel);

    List<Produto> buscarPorRestaurante(Long restaurante);
}