package br.edu.faex.academico.repository;

import br.edu.faex.academico.model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void salvar(Disciplina disciplina){
        disciplinas.add(disciplina);
    }
    public List<Disciplina> listar(){
        return disciplinas;
    }

    public Disciplina buscarPorId(long id){
        for(Disciplina disciplina:disciplinas){
            if (disciplina.getId().equals(id)){
                return disciplina;
            }
        }
        return null;
    }
    public void excluir(long id){
        for(Disciplina disciplina:disciplinas){
            if (disciplina.getId().equals(id)){
                disciplinas.remove(disciplina);
                return;
            }
        }
    }
    public void atualizar(Disciplina disciplinaEditada){
        for(Disciplina disciplina:disciplinas){
            if (disciplina.getId().equals(disciplinaEditada.getId())){
                disciplina.setNome(disciplinaEditada.getNome());
                disciplina.setCargaHoraria(disciplinaEditada.getCargaHoraria());
                disciplina.setCurso(disciplinaEditada.getCurso());
                return;
            }
        }
    }
}
