package br.edu.faex.academico.controller;

import br.edu.faex.academico.model.Disciplina;
import br.edu.faex.academico.service.DisciplinaService;

import java.util.List;

public class DisciplinaController {
    private DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    public void cadastrar(Disciplina disciplina){
        this.service.cadastrar(disciplina);
    }
    public List<Disciplina> listar(){
        return this.service.listar();
    }
    public Disciplina buscarPorId(Long id){
        return service.buscarPorId(id);
    }
    public void atualizar(Disciplina disciplinaEditada){
        service.atualizar(disciplinaEditada);
    }
    public void excluir(Long id){
        service.excluir(id);
    }
}
