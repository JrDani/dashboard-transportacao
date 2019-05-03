package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
