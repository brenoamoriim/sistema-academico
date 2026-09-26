package br.edu.faex.academico;

import br.edu.faex.academico.controller.AlunoController;
import br.edu.faex.academico.controller.ProfessorController;
import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.model.Professor;
import br.edu.faex.academico.repository.AlunoRepository;
import br.edu.faex.academico.repository.ProfessorRepository;
import br.edu.faex.academico.service.AlunoService;
import br.edu.faex.academico.service.ProfessorService;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Aleandro Ribeiro de Lima", "aleandro.lima@faex.edu.br");
        Aluno aluno2 = new Aluno("Maria Helena de Lima", "maria.lima@faex.edu.br");

        AlunoRepository alunoRepository = new AlunoRepository();
        AlunoService alunoService = new AlunoService(alunoRepository);
        AlunoController alunoController = new AlunoController(alunoService);

        alunoController.cadastrar(aluno1);
        alunoController.cadastrar(aluno2);

        for (Aluno aluno : alunoController.listar()) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
            System.out.println("Ativo: " + aluno.isAtivo());
            System.out.println("-------------------------");
        }

        Aluno aluno = alunoController.buscarPorId(1L);
        if (aluno != null) {
            System.out.println("Aluno encontrado!");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
        } else {
            System.out.println("Aluno não encontrado.");
        }

        Aluno alunoEditado = new Aluno("Maria Helena da Silva", "maria.silva@faex.edu.br");
        alunoEditado.setId(2L);
        alunoController.atualizar(alunoEditado);
        for (Aluno alunoLista : alunoController.listar()) {
            System.out.println("ID: " + alunoLista.getId());
            System.out.println("Nome: " + alunoLista.getNome());
            System.out.println("E-mail: " + alunoLista.getEmail());
            System.out.println("-------------------------");
        }

        alunoController.excluir(2L);
        for (Aluno alunoLista : alunoController.listar()) {
            System.out.println("ID: " + alunoLista.getId());
            System.out.println("Nome: " + alunoLista.getNome());
            System.out.println("E-mail: " + alunoLista.getEmail());
            System.out.println("-------------------------");
        }

        Professor professor1 = new Professor("João Pereira", "joao.pereira@faex.edu.br");
        Professor professor2 = new Professor("Ana Souza", "ana.souza@faex.edu.br");

        ProfessorRepository professorRepository = new ProfessorRepository();
        ProfessorService professorService = new ProfessorService(professorRepository);
        ProfessorController professorController = new ProfessorController(professorService);

        professorController.cadastrar(professor1);
        professorController.cadastrar(professor2);

        for (Professor professor : professorController.listar()) {
            System.out.println("Nome: " + professor.getNome());
            System.out.println("E-mail: " + professor.getEmail());
            System.out.println("-------------------------");
        }

        Professor professor = professorController.buscarPorId(1L);
        if (professor != null) {
            System.out.println("Professor encontrado!");
            System.out.println("ID: " + professor.getId());
            System.out.println("Nome: " + professor.getNome());
            System.out.println("E-mail: " + professor.getEmail());
        } else {
            System.out.println("Professor não encontrado.");
        }
    }
}
