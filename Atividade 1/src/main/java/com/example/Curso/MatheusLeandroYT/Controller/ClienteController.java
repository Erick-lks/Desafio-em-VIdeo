package com.example.Curso.MatheusLeandroYT.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Curso.MatheusLeandroYT.Entity.Cliente;
import com.example.Curso.MatheusLeandroYT.Repository.ClienteRepository;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/clientes")
public class ClienteController {
    

    private final ClienteRepository clienteRepository;


    public ClienteController (ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }




    @GetMapping("/listar")
    public ResponseEntity <List<Cliente>>  listarall() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }
    


    @PostMapping("/criar")
    public ResponseEntity<Cliente> criarCliente (@RequestBody Cliente cliente) {
        Cliente clienteNovo = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNovo);
      
    }
    
}
