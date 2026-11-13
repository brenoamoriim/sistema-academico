package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Professor;
import br.edu.faex.academico.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {
    private ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Professor professor){
        if (professor.getNome() == null || professor.getNome().isBlank()) {
            System.out.println("O nome do professor é obrigatório.");
            return;
        }

        if (professor.getEmail() == null || professor.getEmail().isBlank()) {
            System.out.println("O e-mail do professor é obrigatório.");
            return;
        }

        if (!professor.getEmail().contains("@")) {
            System.out.println("E-mail inválido.");
            return;
        }

        if (repository.buscarPorEmail(professor.getEmail()) != null) {
            System.out.println("E-mail já cadastrado.");
            return;
        }

        this.repository.salvar(professor);
    }

    public List<Professor> listar(){
        return repository.listar();
    }

    public Professor buscarPorId(Long id){
        Professor professor = repository.buscarPorId(id);
        if (professor == null){
            System.out.println("Professor não encontrado.");
            return null;
        }
        return professor;
    }

    public void excluir(Long id){
        Professor professor = repository.buscarPorId(id);
        if(professor == null){
            System.out.println("Professor não encontrado.");
            return;
        }
        repository.excluir(id);
    }
}
