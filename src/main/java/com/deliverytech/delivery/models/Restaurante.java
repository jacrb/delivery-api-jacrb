package com.deliverytech.delivery.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;

@Entity
@Builder
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    private String telefone;
    private BigDecimal taxaEntrega;
    private int tempoEntregaMinutos;

    @Builder.Default
    private Boolean ativo = true;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Produto> produtos;

}
