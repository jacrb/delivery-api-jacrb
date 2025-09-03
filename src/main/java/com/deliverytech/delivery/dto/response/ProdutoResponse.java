package com.deliverytech.delivery.dto.response;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    description = "Representa um produto do catálogo do Restaurante", 
    example = "{\"id\":1,\"nome\":\"Calabresa\",\"categoria\":2,\"descricao\":\"Linguiça Calabresa\",\"preco\":10.50,\"disponivel\":true}"
)
public class ProdutoResponse {
    @Schema(
        description = "Identificador único do produto no sistema",
        example = "1"
    )
    private Long id;

     @Schema(
        description = "Nome do produto",
        example = "Pizza 4 queijos"
    )
    private String nome;

    @Schema(
        description = "Nome da categoria do produto",
        example = "pizza"
    )

    private String categoria;

    @Schema(
        description = "Descrição detalhada do produto",
        example = "Pizza 4 queijos - Muçarela, Parmesão, Gorgonzola, etc..."
    )
    private String descricao;

    @Schema(
        description = "Preço em Reais (R$) do produto",
        example = "49.90"
    )
    private BigDecimal preco;

    @Schema(
        description = "Disponibilidade do produto",
        example = "true"
    )
    private Boolean disponivel;

}