package br.com.calculodesalario.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.calculodesalario.exceptions.InfraEstruturaException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/calculodesalario", "root", "root");
        } catch (final SQLException e) {
            throw new InfraEstruturaException("Erro ao tentar criar conexão para banco de dados!");
        }
    }
}
