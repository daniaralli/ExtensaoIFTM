package br.edu.iftm.extensaoSTS.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.iftm.extensaoSTS.domain.Atividade;
import br.edu.iftm.extensaoSTS.repositories.AtividadeRepository;

public class AtividadeService {
   
    @Autowired
    private AtividadeRepository repo;
   
    public Atividade buscar(Integer id) {
       
        Atividade atividade = repo.getOne(id);
        return atividade;
       
    }
}