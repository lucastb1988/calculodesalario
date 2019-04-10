package br.com.calculodesalario.dao;

import java.util.List;

import br.com.calculodesalario.exceptions.InfrastructureException;
import br.com.calculodesalario.model.Discount;

public interface DiscountDao {

    List<Discount> searchDiscountsByEmployeeId(Integer employeeId) throws InfrastructureException;
}
