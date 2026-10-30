package br.edu.faex.academico.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    private final static String URL =
        "jdbc:mysql://localhost:3306/sistema_academico";
    private final static String USUARIO = "root";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USUARIO,
                obterSenha()
        );
    }

    // Lê a senha da variável DB_PASSWORD ou, se não existir, do arquivo db.properties
    private static String obterSenha() throws SQLException {
        String senha = System.getenv("DB_PASSWORD");
        if (senha != null) {
            return senha;
        }

        Properties propriedades = new Properties();
        try (FileInputStream arquivo = new FileInputStream("db.properties")) {
            propriedades.load(arquivo);
        } catch (IOException e) {
            throw new SQLException(
                "Defina DB_PASSWORD ou crie o arquivo db.properties (veja db.properties.example).");
        }
        return propriedades.getProperty("senha", "");
    }
}
