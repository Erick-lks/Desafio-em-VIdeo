package com.example.Atividade3.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Atividade3.Entity.Pedido;
import com.example.Atividade3.Repository.PedidoRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping
public class PedidoController {


    private final PedidoRepository repository;

    public PedidoController(PedidoRepository pedido){

        this.repository = pedido;
    }


    @GetMapping("/listarPedidos")
    public ResponseEntity<List<Pedido>> listarTodosOsPedidos() {
       return ResponseEntity.ok(repository.findAll());
    }

      @GetMapping("/data")
    public ResponseEntity<List<Pedido>> listarpordata(@RequestParam LocalDate data) {
        List<Pedido> pedidosFiltrados = repository.findByData(data);
        return ResponseEntity.ok(pedidosFiltrados);
    }

        @GetMapping("/{id}")
    public ResponseEntity<?> listarProId(@PathVariable Long id) {
        return repository.findById(id).map(pedido -> ResponseEntity.ok(pedido))
        .orElse(ResponseEntity.notFound().build());
    }
    


    @PostMapping("/criar")
  public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido ) {
    Pedido pedidonovo = repository.save(pedido);
    return ResponseEntity.status(HttpStatus.CREATED).body(pedidonovo);
   }
    
}
