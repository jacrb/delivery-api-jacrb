package com.deliverytech.delivery.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.request.PedidoRequest;
import com.deliverytech.delivery.dto.response.ItemPedidoResponse;
import com.deliverytech.delivery.dto.response.PedidoResponse;
import com.deliverytech.delivery.models.Clientes;
import com.deliverytech.delivery.models.ItemPedido;
import com.deliverytech.delivery.models.Pedido;
import com.deliverytech.delivery.models.Produto;
import com.deliverytech.delivery.models.Restaurante;
import com.deliverytech.delivery.models.StatusPedido;
import com.deliverytech.delivery.services.ClienteService;
import com.deliverytech.delivery.services.PedidoService;
import com.deliverytech.delivery.services.ProdutoService;
import com.deliverytech.delivery.services.RestauranteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name= "Restaurantes", description = "Endpoint de Pedidos")
@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;
    private final RestauranteService restauranteService;
    private final ProdutoService produtoService;

    @PostMapping
    @Operation(summary = "Cria um pedido")
    public ResponseEntity<PedidoResponse> criar(@Valid @RequestBody PedidoRequest request) {
        
        Clientes cliente = clienteService.buscarPorId(request.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Restaurante restaurante = restauranteService.buscarPorId(request.getRestauranteId()).orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
        
        List<ItemPedido> itens = request.getItens().stream().map(item -> {
            Produto produto = produtoService.buscarPorId(item.getProdutoId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            return ItemPedido.builder().produto(produto).quantidade(item.getQuantidade()).precoUnitario(produto.getPreco()).build();
        }).collect(Collectors.toList());

        BigDecimal total = itens.stream().map(i -> i.getPrecoUnitario().multiply(BigDecimal.valueOf(i.getQuantidade()))).reduce(BigDecimal.ZERO, BigDecimal::add);
        
        Pedido pedido = Pedido.builder().cliente(cliente)
        .restaurante(restaurante)
        .status(StatusPedido.CRIADO)
        .total(total)
        .enderecoEntrega(request.getEnderecoEntrega())
        .itens(itens)
        .build();

        Pedido salvo = pedidoService.criar(pedido);
        List<ItemPedidoResponse> itensResp = salvo.getItens().stream().map(i -> new ItemPedidoResponse(i.getProduto().getId(), i.getProduto().getNome(), i.getQuantidade(), i.getPrecoUnitario())).collect(Collectors.toList());
        
        return ResponseEntity.ok(new PedidoResponse(
            salvo.getId(),
            cliente.getId(),
            restaurante.getId(),
            salvo.getEnderecoEntrega(),
            salvo.getTotal(),
            salvo.getStatus(),
            salvo.getDataPedido(),
            itensResp
        ));
    }


}
