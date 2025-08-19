package com.deliverytech.delivery.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteRequest {
    @NotBlank
    private String nome;

    @NotBlank
    private String categoria;

    @NotBlank
    private String telefone;

    @Positive
    private BigDecimal taxaEntrega;

    @Min(5)
    @Max(90)
    private Integer tempoEntregaMinutos;
}