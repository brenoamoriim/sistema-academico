package br.edu.faex.academico.repository;

import br.edu.faex.academico.config.Conexao;
import br.edu.faex.academico.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    public void salvar(Aluno aluno){
        String sql = "INSERT INTO alunos (nome, email, ativo) VALUES (?, ?, ?)";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getEmail());
            statement.setBoolean(3, aluno.isAtivo());
            statement.executeUpdate();

            try (ResultSet chaves = statement.getGeneratedKeys()) {
                if (chaves.next()) {
                    aluno.setId(chaves.getLong(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
        }
    }

    public List<Aluno> listar(){
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT id, nome, email, ativo FROM alunos";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {
            while (resultado.next()) {
                alunos.add(mapear(resultado));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
        return alunos;
    }

    public Aluno buscarPorId(Long id){
        String sql = "SELECT id, nome, email, ativo FROM alunos WHERE id = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    return mapear(resultado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
        return null;
    }

    public Aluno buscarPorEmail(String email){
        String sql = "SELECT id, nome, email, ativo FROM alunos WHERE email = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    return mapear(resultado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno por e-mail: " + e.getMessage());
        }
        return null;
    }

    public void excluir(Long id){
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir aluno: " + e.getMessage());
        }
    }

    public void atualizar(Aluno alunoEditado){
        String sql = "UPDATE alunos SET nome = ?, email = ?, ativo = ? WHERE id = ?";
        try (Connection conexao = Conexao.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, alunoEditado.getNome());
            statement.setString(2, alunoEditado.getEmail());
            statement.setBoolean(3, alunoEditado.isAtivo());
            statement.setLong(4, alunoEditado.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    private Aluno mapear(ResultSet resultado) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setId(resultado.getLong("id"));
        aluno.setNome(resultado.getString("nome"));
        aluno.setEmail(resultado.getString("email"));
        aluno.setAtivo(resultado.getBoolean("ativo"));
        return aluno;
    }
}
