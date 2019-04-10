package br.com.calculodesalario.service;

import java.util.List;

import br.com.calculodesalario.model.Desconto;

public interface DescontoService {

    List<Desconto> buscarDescontosPorIdFuncionario(Integer idFuncionario);
}
