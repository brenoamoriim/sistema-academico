package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Disciplina;
import br.edu.faex.academico.repository.DisciplinaRepository;

import java.util.List;

public class DisciplinaService {
    private DisciplinaRepository repository;
    private Long proximoId = 1L;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Disciplina disciplina){
        if (disciplina.getNome() == null || disciplina.getNome().isBlank()) {
            System.out.println("O nome da disciplina é obrigatório.");
            return;
        }

        if (disciplina.getCurso() == null) {
            System.out.println("O curso da disciplina é obrigatório.");
            return;
        }

        if (disciplina.getCargaHoraria() <= 0) {
            System.out.println("A carga horária deve ser maior que zero.");
            return;
        }
        disciplina.setId(proximoId);
        proximoId++;
        this.repository.salvar(disciplina);
    }

    public List<Disciplina> listar(){
        return repository.listar();
    }


    public Disciplina buscarPorId(Long id){
        Disciplina disciplina = repository.buscarPorId(id);
        if (disciplina == null){
            System.out.println("Disciplina não encontrada");
            return null;
        }
        return disciplina;
    }
    public void atualizar(Disciplina disciplinaEditada){
        Disciplina disciplina = repository.buscarPorId(disciplinaEditada.getId());
        if (disciplina == null){
            System.out.println("Disciplina não encontrada.");
            return;
        }

        if (disciplinaEditada.getNome() == null || disciplinaEditada.getNome().isBlank()) {
            System.out.println("O nome da disciplina é obrigatório.");
            return;
        }

        if (disciplinaEditada.getCurso() == null) {
            System.out.println("O curso da disciplina é obrigatório.");
            return;
        }

        if (disciplinaEditada.getCargaHoraria() <= 0) {
            System.out.println("A carga horária deve ser maior que zero.");
            return;
        }

        repository.atualizar(disciplinaEditada);
        System.out.println("Disciplina atualizada com sucesso.");
    }

    public void excluir(Long id){
        Disciplina disciplina = repository.buscarPorId(id);
        if (disciplina == null){
            System.out.println("Disciplina não encontrada");
            return;
        }
        repository.excluir(id);
        System.out.println("Disciplina excluída com sucesso.");
    }

}
