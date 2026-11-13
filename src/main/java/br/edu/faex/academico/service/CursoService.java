package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Curso;
import br.edu.faex.academico.repository.CursoRepository;

import java.util.List;

public class CursoService {
    private CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Curso curso){
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            System.out.println("O nome do curso é obrigatório.");
            return;
        }

        if (curso.getModalidade() == null || curso.getModalidade().isBlank()) {
            System.out.println("A modalidade do curso é obrigatória.");
            return;
        }

        this.repository.salvar(curso);
    }

    public List<Curso> listar(){
        return repository.listar();
    }

    public Curso buscarPorId(Long id){
        Curso curso = repository.buscarPorId(id);
        if (curso == null){
            System.out.println("Curso não encontrado.");
            return null;
        }
        return curso;
    }

    public void excluir(Long id){
        Curso curso = repository.buscarPorId(id);
        if(curso == null){
            System.out.println("Curso não encontrado.");
            return;
        }
        repository.excluir(id);
    }
}
