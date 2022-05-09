package com.api.desafioBackEnd.controllers;


import com.api.desafioBackEnd.models.Filme;
import com.api.desafioBackEnd.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmesRepository filmesRepository;


    @PostMapping
    public Filme saveFilmeContoller(@RequestBody Filme filme){
        return filmesRepository.save(filme);
    }
    @GetMapping
    public List<Filme> getFilmes(){
        return filmesRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Filme> idFilmes(@PathVariable Long id){
        Optional <Filme> filmes = filmesRepository.findById(id);
        return filmes.map(filme -> ResponseEntity.ok().body(filme)).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public void deleteFilmes(@PathVariable Long id){
        filmesRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateFilmes(@RequestBody Filme filme, @PathVariable Long id){
        Optional <Filme> filmes = filmesRepository.findById(id);
        if (filmes.isPresent()){
            Filme filme1 = filmes.get();
            filme1.setNome(filme.getNome());
            filme1.setSinopse(filme.getSinopse());
            filme1.setAnoLancamento(filme.getAnoLancamento());
            filmesRepository.save(filme1);
            return ResponseEntity.ok().build();

        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/por-diretor/{idDiretor}")
    public ResponseEntity<List<Filme>> idDiretor(@PathVariable Long idDiretor){
        List<Filme> filmes = filmesRepository.findAllByDiretorId(idDiretor);
        return ResponseEntity.ok().body(filmes);
    }
    @GetMapping("/por-ator/{idAtor}")
    public ResponseEntity<List<Filme>> idAtor(@PathVariable Long idAtor){
        List<Filme> filmes = filmesRepository.findAll().stream()
                .filter(filme -> filme.getElenco().stream().anyMatch(pessoa -> pessoa.getId() == idAtor))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(filmes);
    }
    @GetMapping("/por-ano/{idAno}")
    public ResponseEntity<List<Filme>> idAno(@PathVariable Integer idAno){
        LocalDate inicio = LocalDate.ofYearDay(idAno, 1);
        LocalDate fim = inicio.with(TemporalAdjusters.lastDayOfYear());
        List<Filme> filmes = filmesRepository.findAllByAnoLancamentoBetween(inicio, fim);
        return ResponseEntity.ok().body(filmes);
    }


}
