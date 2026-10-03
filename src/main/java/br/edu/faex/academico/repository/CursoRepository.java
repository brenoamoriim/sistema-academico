package br.edu.faex.academico.repository;

import br.edu.faex.academico.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();

    public void salvar(Curso curso){
        cursos.add(curso);
    }
    public List<Curso> listar(){
        return cursos;
    }

    public Curso buscarPorId(long id){
        for(Curso curso:cursos){
            if (curso.getId().equals(id)){
                return curso;
            }
        }
        return null;
    }
    public void excluir(long id){
        for(Curso curso:cursos){
            if (curso.getId().equals(id)){
                cursos.remove(curso);
                return;
            }
        }
    }
    public void atualizar(Curso cursoEditado){
        for(Curso curso:cursos){
            if (curso.getId().equals(cursoEditado.getId())){
                curso.setNome(cursoEditado.getNome());
                curso.setModalidade(cursoEditado.getModalidade());
                return;
            }
        }
    }
}
