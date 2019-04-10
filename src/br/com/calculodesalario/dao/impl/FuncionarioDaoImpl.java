package br.com.calculodesalario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calculodesalario.dao.FuncionarioDao;
import br.com.calculodesalario.exceptions.InfraEstruturaException;
import br.com.calculodesalario.factory.ConnectionFactory;
import br.com.calculodesalario.model.Funcionario;
import br.com.calculodesalario.util.DaoUtil;

public class FuncionarioDaoImpl implements FuncionarioDao {

    @Override
    public Funcionario buscar(final Integer id) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        final Funcionario funcionario = new Funcionario();

        try {
            connection = new ConnectionFactory().getConnection();
            ps = connection.prepareStatement("select idFuncionario, nome, salarioBruto from funcionario where idFuncionario = ?");

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                buildEntity(rs, funcionario);
            }

        } catch (final SQLException e) {
            e.getMessage();
            throw new InfraEstruturaException("Erro ao tentar executar operações no banco de dados!");
        } finally {
            DaoUtil.closeConnection(connection, ps, rs);
        }

        return funcionario;
    }

    private void buildEntity(final ResultSet rs, final Funcionario funcionario) throws SQLException {
        funcionario.setId(rs.getInt("idFuncionario"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setSalarioBruto(rs.getBigDecimal("salarioBruto"));
    }

    @Override
    public List<Funcionario> listar() {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        final List<Funcionario> listaFuncionario = new ArrayList<>();

        try {
            connection = new ConnectionFactory().getConnection();
            ps = connection.prepareStatement("select idFuncionario, nome, salarioBruto " + "from funcionario");
            rs = ps.executeQuery();

            while (rs.next()) {
                buildEntity(rs, listaFuncionario);
            }

        } catch (final SQLException e) {
            e.getMessage();
            throw new InfraEstruturaException("Erro ao tentar executar operações no banco de dados!");
        } finally {
            DaoUtil.closeConnection(connection, ps, rs);
        }

        return listaFuncionario;
    }

    private void buildEntity(final ResultSet rs, final List<Funcionario> listaFuncionario) throws SQLException {
        final Funcionario funcionario = new Funcionario();
        funcionario.setId(rs.getInt("idFuncionario"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setSalarioBruto(rs.getBigDecimal("salarioBruto"));

        listaFuncionario.add(funcionario);
    }
}
