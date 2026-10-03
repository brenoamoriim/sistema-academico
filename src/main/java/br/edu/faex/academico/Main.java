package br.edu.faex.academico;

import br.edu.faex.academico.controller.AlunoController;
import br.edu.faex.academico.controller.CursoController;
import br.edu.faex.academico.controller.DisciplinaController;
import br.edu.faex.academico.controller.MatriculaController;
import br.edu.faex.academico.controller.ProfessorController;
import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.model.Curso;
import br.edu.faex.academico.model.Disciplina;
import br.edu.faex.academico.model.Matricula;
import br.edu.faex.academico.model.Professor;
import br.edu.faex.academico.repository.AlunoRepository;
import br.edu.faex.academico.repository.CursoRepository;
import br.edu.faex.academico.repository.DisciplinaRepository;
import br.edu.faex.academico.repository.MatriculaRepository;
import br.edu.faex.academico.repository.ProfessorRepository;
import br.edu.faex.academico.service.AlunoService;
import br.edu.faex.academico.service.CursoService;
import br.edu.faex.academico.service.DisciplinaService;
import br.edu.faex.academico.service.MatriculaService;
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

        Professor professorEditado = new Professor("Ana Souza Lima", "ana.souza@faex.edu.br");
        professorEditado.setId(2L);
        professorController.atualizar(professorEditado);
        professorController.excluir(1L);
        for (Professor professorLista : professorController.listar()) {
            System.out.println("ID: " + professorLista.getId());
            System.out.println("Nome: " + professorLista.getNome());
            System.out.println("E-mail: " + professorLista.getEmail());
            System.out.println("-------------------------");
        }

        Curso curso1 = new Curso("Análise e Desenvolvimento de Sistemas", "Presencial");
        Curso curso2 = new Curso("Engenharia de Software", "EAD");

        CursoRepository cursoRepository = new CursoRepository();
        CursoService cursoService = new CursoService(cursoRepository);
        CursoController cursoController = new CursoController(cursoService);

        cursoController.cadastrar(curso1);
        cursoController.cadastrar(curso2);

        for (Curso curso : cursoController.listar()) {
            System.out.println("ID: " + curso.getId());
            System.out.println("Nome: " + curso.getNome());
            System.out.println("Modalidade: " + curso.getModalidade());
            System.out.println("-------------------------");
        }

        Curso cursoEditado = new Curso("Engenharia de Software", "Presencial");
        cursoEditado.setId(2L);
        cursoController.atualizar(cursoEditado);
        cursoController.excluir(1L);
        for (Curso cursoLista : cursoController.listar()) {
            System.out.println("ID: " + cursoLista.getId());
            System.out.println("Nome: " + cursoLista.getNome());
            System.out.println("Modalidade: " + cursoLista.getModalidade());
            System.out.println("-------------------------");
        }

        Disciplina disciplina1 = new Disciplina("Programação Orientada a Objetos", 80, cursoEditado);
        Disciplina disciplina2 = new Disciplina("Banco de Dados", 60, cursoEditado);

        DisciplinaRepository disciplinaRepository = new DisciplinaRepository();
        DisciplinaService disciplinaService = new DisciplinaService(disciplinaRepository);
        DisciplinaController disciplinaController = new DisciplinaController(disciplinaService);

        disciplinaController.cadastrar(disciplina1);
        disciplinaController.cadastrar(disciplina2);

        for (Disciplina disciplina : disciplinaController.listar()) {
            System.out.println("ID: " + disciplina.getId());
            System.out.println("Nome: " + disciplina.getNome());
            System.out.println("Carga horária: " + disciplina.getCargaHoraria());
            System.out.println("Curso: " + disciplina.getCurso().getNome());
            System.out.println("-------------------------");
        }

        Disciplina disciplinaEditada = new Disciplina("Banco de Dados Avançado", 100, cursoEditado);
        disciplinaEditada.setId(2L);
        disciplinaController.atualizar(disciplinaEditada);
        disciplinaController.excluir(1L);
        for (Disciplina disciplinaLista : disciplinaController.listar()) {
            System.out.println("ID: " + disciplinaLista.getId());
            System.out.println("Nome: " + disciplinaLista.getNome());
            System.out.println("Carga horária: " + disciplinaLista.getCargaHoraria());
            System.out.println("-------------------------");
        }

        Matricula matricula1 = new Matricula(aluno1, disciplinaEditada);

        MatriculaRepository matriculaRepository = new MatriculaRepository();
        MatriculaService matriculaService = new MatriculaService(matriculaRepository);
        MatriculaController matriculaController = new MatriculaController(matriculaService);

        matriculaController.cadastrar(matricula1);

        for (Matricula matricula : matriculaController.listar()) {
            System.out.println("ID: " + matricula.getId());
            System.out.println("Aluno: " + matricula.getAluno().getNome());
            System.out.println("Disciplina: " + matricula.getDisciplina().getNome());
            System.out.println("-------------------------");
        }

        Matricula matriculaEditada = new Matricula(aluno1, disciplinaEditada);
        matriculaEditada.setId(1L);
        matriculaEditada.setNota1(8.5);
        matriculaEditada.setNota2(7.0);
        matriculaController.atualizar(matriculaEditada);

        Matricula matriculaAtualizada = matriculaController.buscarPorId(1L);
        if (matriculaAtualizada != null) {
            System.out.println("Média: " + matriculaAtualizada.getMedia());
            System.out.println("Aprovado: " + matriculaAtualizada.isAprovado());
        }

        matriculaController.excluir(1L);
        for (Matricula matriculaLista : matriculaController.listar()) {
            System.out.println("ID: " + matriculaLista.getId());
            System.out.println("-------------------------");
        }
    }
}
