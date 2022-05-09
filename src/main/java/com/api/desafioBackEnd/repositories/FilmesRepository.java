package com.api.desafioBackEnd.repositories;



import com.api.desafioBackEnd.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface FilmesRepository extends JpaRepository<Filme, Long > {

    public List<Filme> findAllByDiretorId(Long id);
    public List<Filme> findAllByAnoLancamentoBetween(LocalDate inicio, LocalDate fim);


}
