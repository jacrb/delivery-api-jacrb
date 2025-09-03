package com.deliverytech.delivery.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.request.RestauranteRequest;
import com.deliverytech.delivery.dto.response.RestauranteResponse;
import com.deliverytech.delivery.exceptions.ConflictException;
import com.deliverytech.delivery.models.Restaurante;
import com.deliverytech.delivery.services.RestauranteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name= "Restaurantes", description = "Endpoint de Restaurantes")
@RestController
@RequestMapping("/api/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

        private final RestauranteService restauranteService;

        @PostMapping
        @Operation(summary = "Cadastra um Restaurante")
        public ResponseEntity<RestauranteResponse> cadastrar(@Valid @RequestBody RestauranteRequest request) {

                // Validação: Verificar se já existe um restaurante com o mesmo nome
                if (restauranteService.findByNome(request.getNome())) {
                        throw new ConflictException("Já existe um restaurante cadastrado com este nome.", "nome",
                                        request.getNome());
                }

                Restaurante restaurante = Restaurante.builder()
                                .nome(request.getNome())
                                .telefone(request.getTelefone())
                                .categoria(request.getCategoria())
                                .taxaEntrega(request.getTaxaEntrega())
                                .tempoEntregaMinutos(request.getTempoEntregaMinutos())
                                .ativo(true)
                                .build();
                Restaurante salvo = restauranteService.cadastrar(restaurante);
                return ResponseEntity.ok(new RestauranteResponse(
                                salvo.getId(), salvo.getNome(), salvo.getCategoria(), salvo.getTelefone(),
                                salvo.getTaxaEntrega(), salvo.getTempoEntregaMinutos(), salvo.getAtivo()));
        }

        @GetMapping
        @Operation(summary = "Listar todos os restaurantes", description = "Retorna uma lista de todos os restaurantes")
        public List<RestauranteResponse> listarTodos() {
                return restauranteService.listarTodos().stream()
                                .map(r -> new RestauranteResponse(r.getId(), r.getNome(), r.getCategoria(),
                                                r.getTelefone(),
                                                r.getTaxaEntrega(), r.getTempoEntregaMinutos(), r.getAtivo()))
                                .collect(Collectors.toList());
        }

        @GetMapping("/{id}")
        @Operation(summary = "Listar o restaurante por ID", description = "Retorna o restaurante definido pelo ID")
        public ResponseEntity<RestauranteResponse> buscarPorId(@PathVariable Long id) {
                return restauranteService.buscarPorId(id)
                                .map(r -> new RestauranteResponse(r.getId(), r.getNome(), r.getCategoria(),
                                                r.getTelefone(),
                                                r.getTaxaEntrega(), r.getTempoEntregaMinutos(), r.getAtivo()))
                                .map(ResponseEntity::ok)
                                .orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/categoria/{categoria}")
        @Operation(summary = "Listar os restaurantes por categoria", description = "Retorna os restaurantes definidos pela categoria" )
        public List<RestauranteResponse> buscarPorCategoria(@PathVariable String categoria) {
                return restauranteService.buscarPorCategoria(categoria).stream()
                                .map(r -> new RestauranteResponse(r.getId(), r.getNome(), r.getCategoria(),
                                                r.getTelefone(),
                                                r.getTaxaEntrega(), r.getTempoEntregaMinutos(), r.getAtivo()))
                                .collect(Collectors.toList());
        }

        @PutMapping("/{id}")
        @Operation(summary = "Atualiza dados do restaurante", description = "Atualiza dados de um restaurante definindo pelo ID")
        public ResponseEntity<RestauranteResponse> atualizar(@PathVariable Long id,
                        @Valid @RequestBody RestauranteRequest request) {
                Restaurante atualizado = Restaurante.builder()
                                .nome(request.getNome())
                                .telefone(request.getTelefone())
                                .categoria(request.getCategoria())
                                .taxaEntrega(request.getTaxaEntrega())
                                .tempoEntregaMinutos(request.getTempoEntregaMinutos())
                                .build();
                Restaurante salvo = restauranteService.atualizar(id, atualizado);
                return ResponseEntity.ok(new RestauranteResponse(salvo.getId(), salvo.getNome(), salvo.getCategoria(),
                                salvo.getTelefone(), salvo.getTaxaEntrega(), salvo.getTempoEntregaMinutos(),
                                salvo.getAtivo()));
        }
}