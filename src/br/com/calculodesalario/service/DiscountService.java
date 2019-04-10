package br.com.calculodesalario.service;

import java.util.List;

import br.com.calculodesalario.exceptions.InfrastructureException;
import br.com.calculodesalario.model.Discount;

public interface DiscountService {

    List<Discount> searchDiscountsByEmployeeId(Integer employeeId) throws InfrastructureException;
}
