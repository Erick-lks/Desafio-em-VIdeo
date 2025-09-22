package com.example.Curso.MatheusLeandroYT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Curso.MatheusLeandroYT.Entity.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Long> {
    
}
