package com.deliverytech.delivery.dto.response;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
    description = "Representa um item dentro de um pedido", 
    example = "{\"produtoId\":10,\"nomeProduto\":\"Pizza Calabresa\",\"quantidade\":2,\"precoUnitario\":29.90}"
)
public class ItemPedidoResponse {

    @Schema(
        description = "Identificador único do produto",
        example = "10"
    )
    private Long produtoId;

    @Schema(
        description = "Nome do produto no momento do pedido",
        example = "Pizza Calabresa"
    )
    private String nomeProduto;

    @Schema(
        description = "Quantidade do produto no pedido",
        example = "2"
    )
    private Integer quantidade;

    @Schema(
        description = "Preço unitário do produto",
        example = "29.90"
    )
    private BigDecimal precoUnitario;    
}
