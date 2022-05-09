package com.api.desafioBackEnd.controllers;

import com.api.desafioBackEnd.models.Filme;
import com.api.desafioBackEnd.models.Pessoa;
import com.api.desafioBackEnd.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public void savePessoaController(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }
    @GetMapping
    public List<Pessoa> gePessoa(){
        return pessoaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Pessoa idPessoa(@PathVariable Long id){
        return pessoaRepository.findById(id).get();
    }
    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable Long id){
        pessoaRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa p, @PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()){
            Pessoa pessoa1 = pessoa.get();
            pessoa1.setNome(p.getNome());
            pessoaRepository.save(pessoa1);
            return ResponseEntity.ok().build();


        }
        return ResponseEntity.notFound().build();
    }


}
