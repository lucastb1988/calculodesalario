package br.com.calculodesalario.dao;

import java.util.List;

import br.com.calculodesalario.model.Desconto;

public interface DescontoDao {

	List<Desconto> buscarDescontosPorIdFuncionario(Integer idFuncionario);
}
