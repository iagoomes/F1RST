package com.dio.f1rst.bankline.api.controller;

import com.dio.f1rst.bankline.api.dto.NovoCorrentistaDto;
import com.dio.f1rst.bankline.api.model.Correntista;
import com.dio.f1rst.bankline.api.repository.CorrentistaRepository;
import com.dio.f1rst.bankline.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentistaDto correntista){
        service.save(correntista);
    }
}
