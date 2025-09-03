package com.deliverytech.delivery.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    description = "Representa um restaurante disponível no sistema", 
    example = "{\"id\":5,\"nome\":\"Pizzaria Napoli\",\"categoria\":\"Italiana\",\"telefone\":\"(11) 98765-4321\",\"taxaEntrega\":7.50,\"tempoEntregaMinutos\":40,\"ativo\":true}"
)
public class RestauranteResponse {

    @Schema(
        description = "Identificador único do restaurante no sistema",
        example = "5"
    )
    private Long id;

    @Schema(
        description = "Nome do restaurante",
        example = "Pizzaria Napoli"
    )
    private String nome;

    @Schema(
        description = "Categoria ou tipo de culinária do restaurante",
        example = "Italiana"
    )
    private String categoria;

    @Schema(
        description = "Número de telefone do restaurante",
        example = "(11) 98765-4321"
    )
    private String telefone;

    @Schema(
        description = "Valor da taxa de entrega em Reais (R$)",
        example = "7.50"
    )
    private BigDecimal taxaEntrega;

    @Schema(
        description = "Tempo estimado de entrega em minutos",
        example = "40"
    )
    private Integer tempoEntregaMinutos;

    @Schema(
        description = "Indica se o restaurante está ativo no sistema",
        example = "true"
    )
    private Boolean ativo;
}
