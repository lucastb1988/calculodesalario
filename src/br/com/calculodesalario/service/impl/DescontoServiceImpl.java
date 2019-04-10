package br.com.calculodesalario.service.impl;

import java.util.Collections;
import java.util.List;

import br.com.calculodesalario.dao.DescontoDao;
import br.com.calculodesalario.dao.impl.DescontoDaoImpl;
import br.com.calculodesalario.model.Desconto;
import br.com.calculodesalario.service.DescontoService;

public class DescontoServiceImpl implements DescontoService {

    DescontoDao descontoDao = new DescontoDaoImpl();

    @Override
    public List<Desconto> buscarDescontosPorIdFuncionario(final Integer idFuncionario) {

        final List<Desconto> descontos = descontoDao.buscarDescontosPorIdFuncionario(idFuncionario);

        if (descontos == null || descontos.isEmpty()) {
            return Collections.emptyList();
        }

        return descontos;
    }
}
