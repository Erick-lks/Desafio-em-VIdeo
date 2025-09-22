package com.example.Atividade3.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Atividade3.Entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    List<Pedido> findByData(LocalDate data);
    
}
