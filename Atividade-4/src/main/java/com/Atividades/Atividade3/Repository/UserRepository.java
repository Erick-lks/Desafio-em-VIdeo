package com.Atividades.Atividade3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Atividades.Atividade3.Entity.User;



@Repository
public interface UserRepository extends JpaRepository<User , Long>{

 User findByName(String name);
}
