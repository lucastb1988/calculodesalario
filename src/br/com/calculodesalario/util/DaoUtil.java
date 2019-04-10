package br.com.calculodesalario.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.calculodesalario.exceptions.InfrastructureException;

public class DaoUtil {

    private DaoUtil() {

    }

    public static void closeConnection(final Connection connection, final PreparedStatement ps, final ResultSet rs)
                    throws InfrastructureException {

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
            throw new InfrastructureException("Error to execute database operations!", e);
        }
    }
}
