package main;

import java.util.ArrayList;
import java.util.List;

import br.com.calculodesalario.dao.impl.DescontoDaoImpl;
import br.com.calculodesalario.dao.impl.FuncionarioDaoImpl;
import br.com.calculodesalario.model.Desconto;
import br.com.calculodesalario.model.Funcionario;

public class TesteDao {

	public static void main(String[] args) {

		FuncionarioDaoImpl fDao = new FuncionarioDaoImpl();

		Funcionario funcionario = new Funcionario();
		funcionario = fDao.buscar(1);
		System.out.println("Recuperou funcionario: " + funcionario);

		List<Funcionario> listaFuncionario = new ArrayList<>();
		listaFuncionario = fDao.listar();
		System.out.println("Listar funcionarios: " + listaFuncionario);

		
		DescontoDaoImpl dDao = new DescontoDaoImpl();

		List<Desconto> listaDesconto = new ArrayList<>();
		listaDesconto = dDao.buscarDescontosPorIdFuncionario(1);
		System.out.println("Recuperou descontos do funcionario: " + listaDesconto);

	}

}
