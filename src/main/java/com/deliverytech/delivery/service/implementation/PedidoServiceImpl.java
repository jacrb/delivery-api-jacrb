package com.deliverytech.delivery.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery.models.Pedido;
import com.deliverytech.delivery.models.StatusPedido;
import com.deliverytech.delivery.repository.PedidoRepository;
import com.deliverytech.delivery.service.PedidoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;

    @Override // Ela serve para indicar explicitamente que um método está sobrescrevendo um método de uma classe pai ou interface
    public Pedido criar(Pedido pedido){
        pedido.setStatus(StatusPedido.CRIADO);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id){
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> listarPorCliente(Long clienteId){
        return pedidoRepository.findByClienteId(clienteId);
    }

    @Override
    public List<Pedido> listarPorRestaurante(Long restauranteId) {
        return pedidoRepository.findByRestauranteId(restauranteId);
    }

    @Override
    public Pedido atualizarStatus(Long id, StatusPedido status){
        return pedidoRepository.findById(id)
                .map(p -> {
                    p.setStatus(status);
                    return pedidoRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @Override
    public void cancelar(Long id) {
        pedidoRepository.findById(id).ifPresent(p -> {
            p.setStatus(StatusPedido.CANCELADO);
            pedidoRepository.save(p);
        });
    }



}