package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.models.Clientes;
import java.util.Optional;
import java.util.List;



public interface ClienteRepository extends JpaRepository<Clientes, Long>{
    
    Optional<Clientes> findByEmail(String email);
    
    boolean existsByEmail(String email);

    List<Clientes> findByAtivoTrue();
}