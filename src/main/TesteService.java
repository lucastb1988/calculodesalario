package main;

import java.util.List;

import br.com.calculodesalario.model.Funcionario;
import br.com.calculodesalario.service.impl.FuncionarioServiceImpl;

public class TesteService {
	
	public static void main(String[] args) {
		
		FuncionarioServiceImpl service = new FuncionarioServiceImpl();
		
		List<Funcionario> funcionarios = service.calculoSalarioLiquido();
		System.out.println("Funcionarios com salario liquido calculado: " + funcionarios);
		
	}

}
