package com.deliverytech.delivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.models.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    
    Optional<Usuarios> findByEmail(String email);
    
}
