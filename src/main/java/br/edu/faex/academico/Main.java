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

        // Teste anterior
        // Aluno aluno1 = new Aluno("Breno", "breno@example.com");
        // Aluno aluno2 = new Aluno("Maria", "maria@example.com");
        // Aluno aluno3 = new Aluno("Jose", "jose@example.com");
        //
        // controller.cadastrar(aluno1);
        // controller.cadastrar(aluno2);
        // controller.cadastrar(aluno3);

        // Etapa 10 - Testar a implementação (Aula POO Online)
        Aluno aluno1 = new Aluno("Aleandro Ribeiro de Lima", "aleandro.lima@faex.edu.br");
        Aluno aluno2 = new Aluno("Maria Helena de Lima", "maria.lima@faex.edu.br");

        // Cadastrar
        controller.cadastrar(aluno1);
        controller.cadastrar(aluno2);

        // Listar (Atividade prática POO)

        for (Aluno aluno : controller.listar()) {
            System.out.println(aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getEmail());
        }
    }
}
