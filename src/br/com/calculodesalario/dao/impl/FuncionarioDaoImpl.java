package br.com.calculodesalario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calculodesalario.dao.FuncionarioDao;
import br.com.calculodesalario.factory.ConnectionFactory;
import br.com.calculodesalario.model.Funcionario;
import br.com.calculodesalario.util.DaoUtil;

public class FuncionarioDaoImpl implements FuncionarioDao {

	private Connection connection;

	public FuncionarioDaoImpl() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public Funcionario buscar(Integer id) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Funcionario funcionario = new Funcionario();

		try {
			ps = connection.prepareStatement(
					"select idFuncionario, nome, salarioBruto from funcionario where idFuncionario = ?");

			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				buildEntity(rs, funcionario);
			}

		} catch (SQLException e) {
			e.getMessage();
			throw new RuntimeException();
		} finally {
			DaoUtil.closeConnection(connection, ps, rs);
		}

		return funcionario;
	}

	private void buildEntity(ResultSet rs, Funcionario funcionario) throws SQLException {
		funcionario.setId(rs.getInt("idFuncionario"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setSalarioBruto(rs.getBigDecimal("salarioBruto"));
	}

	@Override
	public List<Funcionario> listar() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Funcionario> listaFuncionario = new ArrayList<>();

		try {
			ps = connection.prepareStatement("select idFuncionario, nome, salarioBruto from funcionario");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				buildEntity(rs, listaFuncionario);
			}

		} catch (SQLException e) {
			e.getMessage();
			throw new RuntimeException();
		} finally {
			DaoUtil.closeConnection(connection, ps, rs);
		}

		return listaFuncionario;
	}

	private void buildEntity(ResultSet rs, List<Funcionario> listaFuncionario) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(rs.getInt("idFuncionario"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setSalarioBruto(rs.getBigDecimal("salarioBruto"));
		
		listaFuncionario.add(funcionario);
	}
}
