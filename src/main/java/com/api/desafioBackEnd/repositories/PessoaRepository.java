package com.api.desafioBackEnd.repositories;

import com.api.desafioBackEnd.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  PessoaRepository extends JpaRepository<Pessoa, Long>{


}
