package br.com.calculodesalario.service.impl;

import java.util.Collections;
import java.util.List;

import br.com.calculodesalario.dao.DiscountDao;
import br.com.calculodesalario.dao.impl.DiscountDaoImpl;
import br.com.calculodesalario.exceptions.InfrastructureException;
import br.com.calculodesalario.model.Discount;
import br.com.calculodesalario.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {

    private final DiscountDao discountDao;

    public DiscountServiceImpl() {
        this.discountDao = new DiscountDaoImpl();
    }

    @Override
    public List<Discount> searchDiscountsByEmployeeId(final Integer employeeId) throws InfrastructureException {

        final List<Discount> discountList = discountDao.searchDiscountsByEmployeeId(employeeId);

        if (discountList == null || discountList.isEmpty()) {
            return Collections.emptyList();
        }

        return discountList;
    }
}
