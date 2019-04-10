package br.com.calculodesalario.dao;

import java.util.List;

import br.com.calculodesalario.exceptions.InfrastructureException;
import br.com.calculodesalario.model.Employee;

public interface EmployeeDao {

    List<Employee> listEmployees() throws InfrastructureException;
}
