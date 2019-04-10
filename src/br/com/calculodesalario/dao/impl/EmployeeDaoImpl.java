package br.com.calculodesalario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calculodesalario.dao.EmployeeDao;
import br.com.calculodesalario.exceptions.InfrastructureException;
import br.com.calculodesalario.factory.ConnectionFactory;
import br.com.calculodesalario.model.Employee;
import br.com.calculodesalario.util.DaoUtil;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> listEmployees() throws InfrastructureException {

        final List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement("select idFuncionario, nome, salarioBruto from funcionario");
            rs = ps.executeQuery();

            while (rs.next()) {
                buildEntity(rs, employeeList);
            }

        } catch (final SQLException e) {
            throw new InfrastructureException("Error to execute database operations!", e);
        } finally {
            DaoUtil.closeConnection(connection, ps, rs);
        }

        return employeeList;
    }

    private void buildEntity(final ResultSet rs, final List<Employee> listaFuncionario) throws SQLException {
        final Employee funcionario = new Employee();
        funcionario.setId(rs.getInt("idFuncionario"));
        funcionario.setName(rs.getString("nome"));
        funcionario.setGrossSalary(rs.getBigDecimal("salarioBruto"));

        listaFuncionario.add(funcionario);
    }
}
