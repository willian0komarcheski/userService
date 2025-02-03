package com.estudo.userService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component // Transforma a classe em um Bean gerenciado pelo Spring
public class DataConnection {

    private static Connection connection;

    // Injeção das propriedades do application.properties
    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Value("${database.driver-class-name}")
    private String driverClassName;

    private DataConnection() {
        // Construtor privado para evitar instanciação direta
    }

    @PostConstruct
    public void init() {
        System.out.println("Database URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName(driverClassName); // Carrega o driver do banco de dados
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver do banco de dados não encontrado", e);
            }
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}