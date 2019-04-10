package br.com.calculodesalario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calculodesalario.dao.DescontoDao;
import br.com.calculodesalario.exceptions.InfraEstruturaException;
import br.com.calculodesalario.factory.ConnectionFactory;
import br.com.calculodesalario.model.Desconto;
import br.com.calculodesalario.util.DaoUtil;

public class DescontoDaoImpl implements DescontoDao {

    @Override
    public List<Desconto> buscarDescontosPorIdFuncionario(final Integer idFuncionario) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        final List<Desconto> listaDesconto = new ArrayList<>();

        try {
            connection = new ConnectionFactory().getConnection();
            ps = connection.prepareStatement("select d.idDesconto, d.valorDesconto from desconto d "
                + "join funcionario f on d.idFuncionario = f.idFuncionario where d.idFuncionario = ?");

            ps.setInt(1, idFuncionario);
            rs = ps.executeQuery();

            while (rs.next()) {
                buildEntity(rs, listaDesconto);
            }

        } catch (final SQLException e) {
            e.getMessage();
            throw new InfraEstruturaException("Erro ao tentar executar operações no banco de dados!");
        } finally {
            DaoUtil.closeConnection(connection, ps, rs);
        }

        return listaDesconto;
    }

    private void buildEntity(final ResultSet rs, final List<Desconto> listaDesconto) throws SQLException {
        final Desconto desconto = new Desconto();
        desconto.setId(rs.getInt("idDesconto"));
        desconto.setValorDesconto(rs.getBigDecimal("valorDesconto"));

        listaDesconto.add(desconto);
    }
}
