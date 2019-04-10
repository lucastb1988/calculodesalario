package br.com.calculodesalario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calculodesalario.dao.DiscountDao;
import br.com.calculodesalario.exceptions.InfrastructureException;
import br.com.calculodesalario.factory.ConnectionFactory;
import br.com.calculodesalario.model.Discount;
import br.com.calculodesalario.util.DaoUtil;

public class DiscountDaoImpl implements DiscountDao {

    @Override
    public List<Discount> searchDiscountsByEmployeeId(final Integer employeeId) throws InfrastructureException {

        final List<Discount> discountList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement("select d.idDesconto, d.valorDesconto from desconto d "
                + "join funcionario f on d.idFuncionario = f.idFuncionario where d.idFuncionario = ?");

            ps.setInt(1, employeeId);
            rs = ps.executeQuery();

            while (rs.next()) {
                buildEntity(rs, discountList);
            }

        } catch (final SQLException e) {
            throw new InfrastructureException("Error to execute database operations!", e);
        } finally {
            DaoUtil.closeConnection(connection, ps, rs);
        }

        return discountList;
    }

    private void buildEntity(final ResultSet rs, final List<Discount> discountList) throws SQLException {
        final Discount discount = new Discount();
        discount.setId(rs.getInt("idDesconto"));
        discount.setDiscountValue(rs.getBigDecimal("valorDesconto"));

        discountList.add(discount);
    }
}
