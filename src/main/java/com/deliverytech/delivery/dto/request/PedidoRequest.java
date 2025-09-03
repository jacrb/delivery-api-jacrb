package com.deliverytech.delivery.dto.request;

import java.util.List;

import com.deliverytech.delivery.models.Endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    description = "Requisição para criar um novo pedido",
    example = "{"
            + "\"clienteId\":1,"
            + "\"restauranteId\":5,"
            + "\"enderecoEntrega\":{\"rua\":\"Av. Brasil, 123\",\"cidade\":\"São Paulo\",\"cep\":\"01010-000\"},"
            + "\"itens\":[{\"produtoId\":10,\"quantidade\":2},{\"produtoId\":15,\"quantidade\":1}]"
            + "}"
)
public class PedidoRequest {

    @Schema(
        description = "Identificador do cliente que está realizando o pedido",
        example = "1",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    private Long clienteId;

    @Schema(
        description = "Identificador do restaurante que receberá o pedido",
        example = "5",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    private Long restauranteId;

    @Schema(
        description = "Endereço para entrega do pedido",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    private Endereco enderecoEntrega;

    @Schema(
        description = "Lista de itens que compõem o pedido",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    private List<ItemPedidoRequest> itens;
}
