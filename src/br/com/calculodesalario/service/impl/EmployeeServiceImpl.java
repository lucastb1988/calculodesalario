package br.com.calculodesalario.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.calculodesalario.dao.EmployeeDao;
import br.com.calculodesalario.dao.impl.EmployeeDaoImpl;
import br.com.calculodesalario.exceptions.InfrastructureException;
import br.com.calculodesalario.exceptions.ValidationException;
import br.com.calculodesalario.model.Discount;
import br.com.calculodesalario.model.Employee;
import br.com.calculodesalario.service.DiscountService;
import br.com.calculodesalario.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final DiscountService discountService;

    public EmployeeServiceImpl() {
        this.employeeDao = new EmployeeDaoImpl();
        this.discountService = new DiscountServiceImpl();
    }

    @Override
    public List<Employee> calculateNetSalary() throws InfrastructureException {
        final List<Employee> calculatedEmployeeList = new ArrayList<>();

        final List<Employee> employeeList = listEmployees();
        for (final Employee employee : employeeList) {
            consolidateDiscount(employee);
            calculatedEmployeeList.add(employee);
        }

        calculatedEmployeeList.sort((emp1, emp2) -> emp2.getNetSalary().compareTo(emp1.getNetSalary()));

        return calculatedEmployeeList;
    }

    private void consolidateDiscount(final Employee employee) throws InfrastructureException {
        final List<Discount> discountList = discountService.searchDiscountsByEmployeeId(employee.getId());

        BigDecimal discountSum = new BigDecimal(0);
        for (final Discount discount : discountList) {
            discountSum = discount.getDiscountValue().add(discountSum);
        }

        final BigDecimal netSalary = employee.getGrossSalary().subtract(discountSum);
        employee.setNetSalary(netSalary);
    }

    private List<Employee> listEmployees() throws InfrastructureException {
        final List<Employee> employeeList = employeeDao.listEmployees();

        if (employeeList == null || employeeList.isEmpty()) {
            throw new ValidationException("No employees found!");
        }

        return employeeList;
    }
}
