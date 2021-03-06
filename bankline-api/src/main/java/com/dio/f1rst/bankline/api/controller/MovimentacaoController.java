package com.dio.f1rst.bankline.api.controller;

import com.dio.f1rst.bankline.api.dto.NovaMovimentacaoDto;
import com.dio.f1rst.bankline.api.model.Movimentacao;
import com.dio.f1rst.bankline.api.repository.MovimentacaoRepository;
import com.dio.f1rst.bankline.api.service.CorrentistaService;
import com.dio.f1rst.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacaoDto movimentacao){
        service.save(movimentacao);
    }
}
