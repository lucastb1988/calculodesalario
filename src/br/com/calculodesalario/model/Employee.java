package br.com.calculodesalario.model;

import java.math.BigDecimal;

public class Employee {

    private Integer id;

    private String name;

    private BigDecimal grossSalary;

    private BigDecimal netSalary;

    public Employee() {
        super();
    }

    public Employee(final Integer id, final String name, final BigDecimal grossSalary) {
        super();
        this.id = id;
        this.name = name;
        this.grossSalary = grossSalary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(final BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(final BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + "]";
    }
}
