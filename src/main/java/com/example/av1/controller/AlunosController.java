package com.example.av1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.av1.model.Alunos;
import com.example.av1.service.AlunosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
    @Autowired
    private AlunosService alunosService;

    @GetMapping
    public List<Alunos> getAll(){
        return alunosService.findAll();
    }

    @PostMapping
    public Alunos create(@RequestBody Alunos aluno){
        return alunosService.save(aluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alunos> getAluno(@PathVariable Long id){
        return alunosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alunos> updateAluno(@PathVariable Long id, @RequestBody Alunos aluno){
        return alunosService.update(id, aluno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return alunosService.delete(id);
    }
}
