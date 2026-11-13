package br.edu.faex.academico.repository;

import br.edu.faex.academico.config.Conexao;
import br.edu.faex.academico.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {

    public void salvar(Curso curso){
        String sql = "INSERT INTO cursos (nome, modalidade) VALUES (?, ?)";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getModalidade());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Curso cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    public List<Curso> listar(){
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT id, nome, modalidade FROM cursos";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Curso curso = new Curso();
                curso.setId(resultado.getLong("id"));
                curso.setNome(resultado.getString("nome"));
                curso.setModalidade(resultado.getString("modalidade"));
                cursos.add(curso);
            }

            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return cursos;
    }

    public Curso buscarPorId(Long id){
        String sql = "SELECT * FROM cursos WHERE id = ?";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setLong(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Curso curso = new Curso();
                curso.setId(resultado.getLong("id"));
                curso.setNome(resultado.getString("nome"));
                curso.setModalidade(resultado.getString("modalidade"));

                resultado.close();
                comando.close();
                conexao.close();
                return curso;
            }

            resultado.close();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar curso: " + e.getMessage());
        }
        return null;
    }

    public void excluir(Long id){
        String sql = "DELETE FROM cursos WHERE id = ?";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setLong(1, id);
            int registrosAfetados = comando.executeUpdate();

            comando.close();
            conexao.close();

            if (registrosAfetados > 0) {
                System.out.println("Curso excluído com sucesso!");
            } else {
                System.out.println("Nenhum curso encontrado com o ID informado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir curso: " + e.getMessage());
        }
    }
}
