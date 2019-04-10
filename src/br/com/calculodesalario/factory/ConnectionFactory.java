package br.com.calculodesalario.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.calculodesalario.exceptions.InfrastructureException;

public class ConnectionFactory {

    private ConnectionFactory() {

    }

    private static final String URL = "jdbc:mysql://localhost:3306/calculodesalario";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws InfrastructureException {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (final SQLException e) {
            throw new InfrastructureException("Erro ao tentar criar conexão para banco de dados!", e);
        }
    }
}
