package com.example.Curso.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Curso.Entitu.Produtos;
import com.example.Curso.Repository.ProdutosRepository;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private final ProdutosRepository produtosRepository;


    public ProdutoController ( ProdutosRepository produtosRepository){
        this.produtosRepository = produtosRepository;
    }


    @GetMapping("/listar")
    public ResponseEntity<List<Produtos>> listar () {
        return ResponseEntity.ok(produtosRepository.findAll());
    }
    

     @PostMapping("/criar")
    public ResponseEntity<Produtos> criarProdutos(@RequestBody Produtos produto) {
        Produtos produtosNovo = produtosRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosNovo);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Produtos>> filtrar(@RequestParam String nome) {
        List<Produtos> produtosFiltrados = produtosRepository.findByNomeContainingIgnoreCase(nome);
        return ResponseEntity.ok(produtosFiltrados);
    }
}
