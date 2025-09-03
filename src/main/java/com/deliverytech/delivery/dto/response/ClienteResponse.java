package com.deliverytech.delivery.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    description = "Representa um cliente do sistema", 
    example = "{\"id\":1,\"nome\":\"João da Silva\",\"email\":\"joao.silva@email.com\",\"ativo\":true}"
)
public class ClienteResponse {

    @Schema(
        description = "Identificador único do cliente no sistema",
        example = "1"
    )
    private Long id;

    @Schema(
        description = "Nome completo do cliente",
        example = "João da Silva"
    )
    private String nome;

    @Schema(
        description = "Endereço de e-mail do cliente",
        example = "joao.silva@email.com"
    )
    private String email;

    @Schema(
        description = "Indica se o cliente está ativo no sistema",
        example = "true"
    )
    private Boolean ativo;
}
