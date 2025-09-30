package com.Atividades.Atividade3.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.Atividades.Atividade3.Entity.User;
import com.Atividades.Atividade3.Repository.UserRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class UserController {


    private final UserRepository repository;


    public UserController (UserRepository repository){
        this.repository = repository;
    }



    @GetMapping("/listar")
    public ResponseEntity<List<User>> listarTodos ( ) {
        return ResponseEntity.ok(repository.findAll());
    }

    
    @GetMapping("/filtro/{name}")
    public ResponseEntity<?> listarfiltro ( @PathVariable String name) {
        User filtro = repository.findByName(name);

        if(filtro == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Usuario nao encontrado!"));
        }
        return ResponseEntity.ok(filtro);
    }

  @PostMapping("/criar")
  public ResponseEntity<User> criar(@RequestBody User user) {
  User usernovo = repository.save(user);     
      return ResponseEntity.status(200).body(usernovo);
  }


  @PutMapping("/{id}")
  public ResponseEntity<User> alterarUser (@PathVariable Long id, @RequestBody User user) {
      User useratualizado = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não Existe"));


      useratualizado.setName(user.getName());
      useratualizado.setUsername(user.getUsername());
      useratualizado.setPassword(user.getPassword());


      User usersalvo = repository.save(useratualizado);
      
      
      return ResponseEntity.ok(repository.save(usersalvo));
  }
  
    
    
}
