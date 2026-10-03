package br.edu.faex.academico.controller;

import br.edu.faex.academico.model.Matricula;
import br.edu.faex.academico.service.MatriculaService;

import java.util.List;

public class MatriculaController {
    private MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    public void cadastrar(Matricula matricula){
        this.service.cadastrar(matricula);
    }
    public List<Matricula> listar(){
        return this.service.listar();
    }
    public Matricula buscarPorId(Long id){
        return service.buscarPorId(id);
    }
    public void atualizar(Matricula matriculaEditada){
        service.atualizar(matriculaEditada);
    }
    public void excluir(Long id){
        service.excluir(id);
    }
}
