package com.deliverytech.delivery.models;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
