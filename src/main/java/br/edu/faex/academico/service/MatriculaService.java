package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Matricula;
import br.edu.faex.academico.repository.MatriculaRepository;

import java.util.List;

public class MatriculaService {
    private MatriculaRepository repository;
    private Long proximoId = 1L;

    public MatriculaService(MatriculaRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Matricula matricula){
        if (matricula.getAluno() == null) {
            System.out.println("O aluno da matrícula é obrigatório.");
            return;
        }

        if (matricula.getDisciplina() == null) {
            System.out.println("A disciplina da matrícula é obrigatória.");
            return;
        }

        if (repository.listar().stream()
                .anyMatch(m -> m.getAluno().getId().equals(matricula.getAluno().getId())
                        && m.getDisciplina().getId().equals(matricula.getDisciplina().getId()))) {
            System.out.println("Aluno já matriculado nesta disciplina.");
            return;
        }
        matricula.setId(proximoId);
        proximoId++;
        this.repository.salvar(matricula);
    }

    public List<Matricula> listar(){
        return repository.listar();
    }


    public Matricula buscarPorId(Long id){
        Matricula matricula = repository.buscarPorId(id);
        if (matricula == null){
            System.out.println("Matrícula não encontrada");
            return null;
        }
        return matricula;
    }
    public void atualizar(Matricula matriculaEditada){
        Matricula matricula = repository.buscarPorId(matriculaEditada.getId());
        if (matricula == null){
            System.out.println("Matrícula não encontrada.");
            return;
        }

        if (matriculaEditada.getAluno() == null) {
            System.out.println("O aluno da matrícula é obrigatório.");
            return;
        }

        if (matriculaEditada.getDisciplina() == null) {
            System.out.println("A disciplina da matrícula é obrigatória.");
            return;
        }

        if (matriculaEditada.getNota1() < 0 || matriculaEditada.getNota1() > 10
                || matriculaEditada.getNota2() < 0 || matriculaEditada.getNota2() > 10) {
            System.out.println("As notas devem estar entre 0 e 10.");
            return;
        }

        repository.atualizar(matriculaEditada);
        System.out.println("Matrícula atualizada com sucesso.");
    }

    public void excluir(Long id){
        Matricula matricula = repository.buscarPorId(id);
        if (matricula == null){
            System.out.println("Matrícula não encontrada");
            return;
        }
        repository.excluir(id);
        System.out.println("Matrícula excluída com sucesso.");
    }

}
