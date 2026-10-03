package br.edu.faex.academico.repository;

import br.edu.faex.academico.model.Matricula;

import java.util.ArrayList;
import java.util.List;

public class MatriculaRepository {
    private List<Matricula> matriculas = new ArrayList<>();

    public void salvar(Matricula matricula){
        matriculas.add(matricula);
    }
    public List<Matricula> listar(){
        return matriculas;
    }

    public Matricula buscarPorId(long id){
        for(Matricula matricula:matriculas){
            if (matricula.getId().equals(id)){
                return matricula;
            }
        }
        return null;
    }
    public void excluir(long id){
        for(Matricula matricula:matriculas){
            if (matricula.getId().equals(id)){
                matriculas.remove(matricula);
                return;
            }
        }
    }
    public void atualizar(Matricula matriculaEditada){
        for(Matricula matricula:matriculas){
            if (matricula.getId().equals(matriculaEditada.getId())){
                matricula.setAluno(matriculaEditada.getAluno());
                matricula.setDisciplina(matriculaEditada.getDisciplina());
                matricula.setNota1(matriculaEditada.getNota1());
                matricula.setNota2(matriculaEditada.getNota2());
                return;
            }
        }
    }
}
