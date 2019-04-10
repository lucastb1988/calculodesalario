package br.com.calculodesalario.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.calculodesalario.exceptions.InfraEstruturaException;

public class DaoUtil {

    private DaoUtil() {

    }

    public static void closeConnection(final Connection connection, final PreparedStatement ps, final ResultSet rs) {

        try {

            if (connection != null) {
                connection.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (rs != null) {
                rs.close();
            }

        } catch (final SQLException e) {
            e.getMessage();
            throw new InfraEstruturaException("Erro ao tentar executar operações no banco de dados!");
        }
    }
}
