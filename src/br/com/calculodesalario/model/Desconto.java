package br.com.calculodesalario.model;

import java.math.BigDecimal;

public class Desconto {

    private Integer id;

    private BigDecimal valorDesconto;

    public Desconto() {

    }

    public Desconto(final Integer id, final BigDecimal valorDesconto) {
        super();
        this.id = id;
        this.valorDesconto = valorDesconto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(final BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
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
        final Desconto other = (Desconto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Descontos [id = " + id + ", valorDesconto = " + valorDesconto + "]";
    }
}
