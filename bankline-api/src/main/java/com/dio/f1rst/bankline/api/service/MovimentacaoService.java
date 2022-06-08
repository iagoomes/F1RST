package com.dio.f1rst.bankline.api.service;

import com.dio.f1rst.bankline.api.dto.NovaMovimentacaoDto;
import com.dio.f1rst.bankline.api.model.Correntista;
import com.dio.f1rst.bankline.api.model.Movimentacao;
import com.dio.f1rst.bankline.api.model.MovimentacaoTipo;
import com.dio.f1rst.bankline.api.repository.CorrentistaRepository;
import com.dio.f1rst.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacaoDto novaMovimentacaoDto){
        Movimentacao movimentacao = new Movimentacao();
        Double valor = novaMovimentacaoDto.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacaoDto.getValor() : novaMovimentacaoDto.getValor() * -1;
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacaoDto.getDescricao());
        movimentacao.setId_conta(novaMovimentacaoDto.getId_conta());
        movimentacao.setTipo(novaMovimentacaoDto.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.
                findById(novaMovimentacaoDto.getId_conta()).
                orElse(null);

        if (correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }
}
