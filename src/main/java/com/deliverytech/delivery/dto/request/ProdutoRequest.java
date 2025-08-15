package com.deliverytech.delivery.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
    private String nome;
    private String categoria;
    private String descricao;
    private BigDecimal preco;
    private Long restauranteId;
}
