package com.deliverytech.delivery.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    description = "Requisição para adicionar um item a um pedido",
    example = "{\"produtoId\":10,\"quantidade\":2}"
)
public class ItemPedidoRequest {

    @Schema(
        description = "Identificador do produto a ser incluído no pedido",
        example = "10",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    private Long produtoId;

    @Schema(
        description = "Quantidade do produto no pedido",
        example = "2",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Positive
    private Integer quantidade;
}
