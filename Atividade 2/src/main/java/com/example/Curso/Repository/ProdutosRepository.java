package com.example.Curso.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Curso.Entitu.Produtos;


@Repository
public interface ProdutosRepository  extends JpaRepository<Produtos, Long>{

    List<Produtos> findByNomeContainingIgnoreCase(String nome);
    
}
