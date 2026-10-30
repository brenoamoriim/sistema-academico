package br.edu.faex.academico;

import br.edu.faex.academico.controller.AlunoController;
import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.repository.AlunoRepository;
import br.edu.faex.academico.service.AlunoService;

public class Main {
    static void main() {
        AlunoRepository repository = new AlunoRepository();
        AlunoService service = new AlunoService(repository);
        AlunoController controller = new AlunoController(service);

        Aluno aluno1 = new Aluno("Breno", "breno@example.com");
        Aluno aluno2 = new Aluno("Maria", "maria@example.com");
        Aluno aluno3 = new Aluno("Jose", "jose@example.com");

        controller.cadastrar(aluno1);
        controller.cadastrar(aluno2);
        controller.cadastrar(aluno3);

        for (Aluno aluno : controller.listar()) {
            System.out.println(aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getEmail());
        }
    }
}
