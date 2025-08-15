package com.deliverytech.delivery.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoRequest {
    private Long produtoId;
    private Integer quantidade;
}