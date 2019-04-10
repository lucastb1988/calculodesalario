package br.com.calculodesalario.service;

import java.util.List;

import br.com.calculodesalario.exceptions.InfrastructureException;
import br.com.calculodesalario.model.Employee;

public interface EmployeeService {

    List<Employee> calculateNetSalary() throws InfrastructureException;
}
