package ivan.pronin.c2.accounting.model;

import java.math.BigDecimal;

/**
 * Created by Администратор on 27.01.2016.
 */
public class TaxRates {
    private Long id;
    private String name;
    private BigDecimal value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxRates taxRates = (TaxRates) o;

        if (id != null ? !id.equals(taxRates.id) : taxRates.id != null) return false;
        if (name != null ? !name.equals(taxRates.name) : taxRates.name != null) return false;
        if (value != null ? !value.equals(taxRates.value) : taxRates.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
