package com.estudo.userService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.SQLException;

import com.estudo.userService.config.DataConnection;

@Component
public class Bootstrap implements CommandLineRunner {

    private final DataConnection Connection;

    public Bootstrap(DataConnection connection) {
        this.Connection = connection;
    }

    @Override
    public void run(String... args) throws Exception {
        // Testa a conexão com o banco de dados
        try (Connection conn = Connection.getConnection()) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}