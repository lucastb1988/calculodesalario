package br.com.calculodesalario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calculodesalario.dao.DescontoDao;
import br.com.calculodesalario.factory.ConnectionFactory;
import br.com.calculodesalario.model.Desconto;

public class DescontoDaoImpl implements DescontoDao {

	private Connection connection;

	public DescontoDaoImpl() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public List<Desconto> buscarDescontosPorIdFuncionario(Integer idFuncionario) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Desconto> listaDesconto = new ArrayList<Desconto>();

		try {
			ps = connection.prepareStatement("select idDesconto, valorDesconto from desconto where idFuncionario = ?");
			ps.setInt(1, idFuncionario);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				buildEntity(rs, listaDesconto);
			}

		} catch (SQLException e) {
			e.getMessage();
			throw new RuntimeException();
		} 

		return listaDesconto;
	}

	private void buildEntity(ResultSet rs, List<Desconto> listaDesconto) throws SQLException {
		Desconto desconto = new Desconto();
		desconto.setId(rs.getInt("idDesconto"));
		desconto.setValorDesconto(rs.getBigDecimal("valorDesconto"));
		
		listaDesconto.add(desconto);
	}
}
