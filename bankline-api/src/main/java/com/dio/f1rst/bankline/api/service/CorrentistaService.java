package com.dio.f1rst.bankline.api.service;

import com.dio.f1rst.bankline.api.dto.NovoCorrentistaDto;
import com.dio.f1rst.bankline.api.model.Conta;
import com.dio.f1rst.bankline.api.model.Correntista;
import com.dio.f1rst.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository repository;

    public void save(NovoCorrentistaDto novoCorrentistaDto){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentistaDto.getCpf());
        correntista.setNome(novoCorrentistaDto.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        repository.save(correntista);
    }
}
