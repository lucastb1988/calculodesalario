package br.com.calculodesalario.model;

import java.math.BigDecimal;

public class Funcionario {

    private Integer id;

    private String nome;

    private BigDecimal salarioBruto;

    private BigDecimal salarioLiquido;

    public Funcionario() {
        super();
    }

    public Funcionario(final Integer id, final String nome, final BigDecimal salarioBruto) {
        super();
        this.id = id;
        this.nome = nome;
        this.salarioBruto = salarioBruto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(final BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public BigDecimal getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(final BigDecimal salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
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
        final Funcionario other = (Funcionario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario [id = " + id + ", nome = " + nome + ", salarioBruto = " + salarioBruto + ", salarioLiquido = " + salarioLiquido
            + "]";
    }
}
