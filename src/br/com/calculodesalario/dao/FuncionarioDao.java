package br.com.calculodesalario.dao;

import java.util.List;

import br.com.calculodesalario.model.Funcionario;

public interface FuncionarioDao {
	
	Funcionario buscar(Integer id);
	
	List<Funcionario> listar();
}
