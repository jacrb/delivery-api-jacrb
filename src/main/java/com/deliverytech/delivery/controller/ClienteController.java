package com.deliverytech.delivery.controller;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.response.ClienteResponse;
import com.deliverytech.delivery.service.ClienteService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteResponse> listar() {
        return clienteService.listarAtivos().stream()
                .map(c -> new ClienteResponse(c.getId(), c.getNome(), c.getEmail(), c.getAtivo()))
                .collect(Collectors.toList());
    }
}
 