package br.com.calculodesalario.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.calculodesalario.dao.FuncionarioDao;
import br.com.calculodesalario.dao.impl.FuncionarioDaoImpl;
import br.com.calculodesalario.exceptions.ValidacaoException;
import br.com.calculodesalario.model.Desconto;
import br.com.calculodesalario.model.Funcionario;
import br.com.calculodesalario.service.DescontoService;
import br.com.calculodesalario.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {

    FuncionarioDao funcionarioDao = new FuncionarioDaoImpl();
    DescontoService descontoService = new DescontoServiceImpl();

    @Override
    public List<Funcionario> calculoSalarioLiquido() {
        final List<Funcionario> listaFuncionariosCalculados = new ArrayList<>();

        final List<Funcionario> funcionarios = listarFuncionarios();

        BigDecimal somaDesconto = new BigDecimal(0);
        for (final Funcionario funcionario : funcionarios) {

            final List<Desconto> descontos = descontoService.buscarDescontosPorIdFuncionario(funcionario.getId());
            for (final Desconto desconto : descontos) {
                somaDesconto = desconto.getValorDesconto().add(somaDesconto);
            }

            final BigDecimal salarioLiquido = funcionario.getSalarioBruto().subtract(somaDesconto);
            funcionario.setSalarioLiquido(salarioLiquido);

            listaFuncionariosCalculados.add(funcionario);
        }

        comparatorSalarioLiquidoDescendente(listaFuncionariosCalculados);

        return listaFuncionariosCalculados;
    }

    private List<Funcionario> listarFuncionarios() {
        final List<Funcionario> funcionarios = funcionarioDao.listar();

        if (funcionarios == null || funcionarios.isEmpty()) {
            throw new ValidacaoException("Não foram encontrados funcionários para cálculo!");
        }
        return funcionarios;
    }

    private void comparatorSalarioLiquidoDescendente(final List<Funcionario> listaFuncionariosCalculados) {
        Collections.sort(listaFuncionariosCalculados, new Comparator<Funcionario>() {

            @Override
            public int compare(final Funcionario o1, final Funcionario o2) {
                return o2.getSalarioLiquido().compareTo(o1.getSalarioLiquido());
            }
        });
    }
}
