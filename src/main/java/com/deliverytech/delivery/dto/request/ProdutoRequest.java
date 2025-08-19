package com.deliverytech.delivery.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
    
    @NotBlank
    private String nome;

    @NotBlank
    private String categoria;

    @NotBlank
    private String descricao;

    @DecimalMin("0.01")
    @DecimalMax("5000.0")
    private BigDecimal preco;

    
    private Long restauranteId;
}