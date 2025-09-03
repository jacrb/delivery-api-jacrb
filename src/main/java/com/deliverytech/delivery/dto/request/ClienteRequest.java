package com.deliverytech.delivery.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    description = "Requisição para criar ou atualizar um cliente",
    example = "{\"nome\":\"João da Silva\",\"email\":\"joao.silva@email.com\"}"
)
public class ClienteRequest {

    @Schema(
        description = "Nome completo do cliente",
        example = "João da Silva",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank
    private String nome;

    @Schema(
        description = "Endereço de e-mail válido do cliente",
        example = "joao.silva@email.com",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Email
    @NotBlank
    private String email;
}
