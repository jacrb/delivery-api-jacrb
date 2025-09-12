package com.deliverytech.delivery.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.models.Clientes;
import com.deliverytech.delivery.repository.ClienteRepository;
import com.deliverytech.delivery.services.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    @Override
    public Clientes cadastrar(Clientes cliente) {

        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new RuntimeException("Email já cadastrado: " + cliente.getEmail());
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Clientes> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Clientes> listarAtivos() {
        return clienteRepository.findByAtivoTrue();
    }

    @Override
    public Clientes atualizar(Long id, Clientes atualizado) {
        return clienteRepository.findById(id)
                .map(c -> {

                    if (!c.getEmail().equals(atualizado.getEmail()) && 
                    clienteRepository.existsByEmail(atualizado.getEmail())) {
                    throw new RuntimeException("Email já cadastrado: " + atualizado.getEmail());
                    }
                    c.setNome(atualizado.getNome());
                    c.setEmail(atualizado.getEmail());
                    return clienteRepository.save(c);
                })
                .orElseThrow(
                        () -> new RuntimeException("Cliente não encontrado"));
    }
    @Override
    public void ativarDesativar(Long id) {
        clienteRepository.findById(id).ifPresent(c -> {
            c.setAtivo(!c.getAtivo());
            clienteRepository.save(c);
        });
    }
}