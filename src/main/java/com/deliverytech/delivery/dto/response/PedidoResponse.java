package com.deliverytech.delivery.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.deliverytech.delivery.models.Endereco;
import com.deliverytech.delivery.models.StatusPedido;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    description = "Representa um pedido realizado por um cliente", 
    example = "{\"id\":101,\"clienteId\":1,\"restauranteId\":5,\"enderecoEntrega\":{\"rua\":\"Av. Brasil, 123\",\"cidade\":\"São Paulo\",\"cep\":\"01010-000\"},\"total\":89.90,\"status\":\"EM_ANDAMENTO\",\"dataPedido\":\"2025-08-27T13:45:00\",\"itens\":[{\"produtoId\":10,\"quantidade\":2,\"precoUnitario\":29.90}]}"
)
public class PedidoResponse {

    @Schema(
        description = "Identificador único do pedido no sistema",
        example = "101"
    )
    private Long id;

    @Schema(
        description = "Identificador único do cliente que realizou o pedido",
        example = "1"
    )
    private Long clienteId;

    @Schema(
        description = "Identificador único do restaurante responsável pelo pedido",
        example = "5"
    )
    private Long restauranteId;

    @Schema(
        description = "Endereço de entrega associado ao pedido"
    )
    private Endereco enderecoEntrega;

    @Schema(
        description = "Valor total do pedido em Reais (R$)",
        example = "89.90"
    )
    private BigDecimal total;

    @Schema(
        description = "Status atual do pedido",
        example = "EM_PREPARACAO"
    )
    private StatusPedido status;

    @Schema(
        description = "Data e hora em que o pedido foi realizado",
        example = "2025-08-27T13:45:00"
    )
    private LocalDateTime dataPedido;

    @Schema(
        description = "Lista de itens que compõem o pedido"
    )
    private List<ItemPedidoResponse> itens;
}
