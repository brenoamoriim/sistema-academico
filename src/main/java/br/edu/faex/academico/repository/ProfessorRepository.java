package br.edu.faex.academico.repository;

import br.edu.faex.academico.config.Conexao;
import br.edu.faex.academico.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {

    public void salvar(Professor professor){
        String sql = "INSERT INTO professores (nome, email) VALUES (?, ?)";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Professor cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    public List<Professor> listar(){
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT id, nome, email FROM professores";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Professor professor = new Professor();
                professor.setId(resultado.getLong("id"));
                professor.setNome(resultado.getString("nome"));
                professor.setEmail(resultado.getString("email"));
                professores.add(professor);
            }

            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return professores;
    }

    public Professor buscarPorId(Long id){
        String sql = "SELECT * FROM professores WHERE id = ?";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setLong(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Professor professor = new Professor();
                professor.setId(resultado.getLong("id"));
                professor.setNome(resultado.getString("nome"));
                professor.setEmail(resultado.getString("email"));

                resultado.close();
                comando.close();
                conexao.close();
                return professor;
            }

            resultado.close();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar professor: " + e.getMessage());
        }
        return null;
    }

    public Professor buscarPorEmail(String email){
        String sql = "SELECT * FROM professores WHERE email = ?";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, email);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Professor professor = new Professor();
                professor.setId(resultado.getLong("id"));
                professor.setNome(resultado.getString("nome"));
                professor.setEmail(resultado.getString("email"));

                resultado.close();
                comando.close();
                conexao.close();
                return professor;
            }

            resultado.close();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar professor por e-mail: " + e.getMessage());
        }
        return null;
    }

    public void excluir(Long id){
        String sql = "DELETE FROM professores WHERE id = ?";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setLong(1, id);
            int registrosAfetados = comando.executeUpdate();

            comando.close();
            conexao.close();

            if (registrosAfetados > 0) {
                System.out.println("Professor excluído com sucesso!");
            } else {
                System.out.println("Nenhum professor encontrado com o ID informado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir professor: " + e.getMessage());
        }
    }
}
