package com.deliverytech.delivery.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteRequest {
    private String nome;
    private String categoria;
    private String telefone;
    private BigDecimal taxaEntrega;
    private Integer tempoEntregaMinutos;
}