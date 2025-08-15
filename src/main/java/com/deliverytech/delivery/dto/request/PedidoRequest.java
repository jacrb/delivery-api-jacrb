package com.deliverytech.delivery.dto.request;

import java.util.List;

import com.deliverytech.delivery.models.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {
    private Long clienteId;
    private Long restauranteId;
    private Endereco enderecoEntrega;
    private List<ItemPedidoRequest> itens;
}
