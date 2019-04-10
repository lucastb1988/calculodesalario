package br.com.calculodesalario.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.calculodesalario.dao.DescontoDao;
import br.com.calculodesalario.dao.FuncionarioDao;
import br.com.calculodesalario.dao.impl.DescontoDaoImpl;
import br.com.calculodesalario.dao.impl.FuncionarioDaoImpl;
import br.com.calculodesalario.exceptions.ValidacaoException;
import br.com.calculodesalario.model.Desconto;
import br.com.calculodesalario.model.Funcionario;
import br.com.calculodesalario.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {

	FuncionarioDao funcionarioDao = new FuncionarioDaoImpl();
	DescontoDao descontoDao = new DescontoDaoImpl();

	@Override
	public List<Funcionario> calculoSalarioLiquido() {
		List<Funcionario> listaFuncionariosCalculados = new ArrayList<>();

		List<Funcionario> funcionarios = funcionarioDao.listar();
		
		if (funcionarios == null || funcionarios.isEmpty()) {
			throw new ValidacaoException("Não foram encontrados funcionários para cálculo!");
		}
		
		BigDecimal somaDesconto = new BigDecimal(0);
		for (Funcionario funcionario : funcionarios) {
			
			List<Desconto> descontos = descontoDao.buscarDescontosPorIdFuncionario(funcionario.getId());
			for (Desconto desconto : descontos) {
				somaDesconto = desconto.getValorDesconto().add(somaDesconto);
			}
			
			BigDecimal salarioLiquido = funcionario.getSalarioBruto().subtract(somaDesconto);
			funcionario.setSalarioLiquido(salarioLiquido);
			
			listaFuncionariosCalculados.add(funcionario);
		}
		
		comparatorSalarioLiquidoDescendente(listaFuncionariosCalculados);
		
		return listaFuncionariosCalculados;
	}

	private void comparatorSalarioLiquidoDescendente(List<Funcionario> listaFuncionariosCalculados) {
		Collections.sort(listaFuncionariosCalculados, new Comparator<Funcionario>() {

			@Override
			public int compare(Funcionario o1, Funcionario o2) {
				return o2.getSalarioLiquido().compareTo(o1.getSalarioLiquido());
			}
		});
	}
}
