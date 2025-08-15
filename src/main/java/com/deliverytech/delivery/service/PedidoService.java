package com.deliverytech.delivery.service;

import java.util.List;
import java.util.Optional;

import com.deliverytech.delivery.models.Pedido;
import com.deliverytech.delivery.models.StatusPedido;

public interface PedidoService {

    Pedido criar(Pedido pedido);
    Pedido atualizarStatus(Long id, StatusPedido status);

    Optional<Pedido> buscarPorId(Long id);

    void cancelar(Long id);

    List<Pedido> listarPorCliente(Long clienteId);
    List<Pedido> listarPorRestaurante(Long restauranteId);


}


