package com.deliverytech.delivery.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Builder.Default
    private Boolean ativo = true;

    @Embedded
    private Endereco enderecoCliente;
    
    @Builder.Default
    private LocalDateTime dataCriacao = LocalDateTime.now();

}


