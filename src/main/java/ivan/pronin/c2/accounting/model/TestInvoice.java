package ivan.pronin.c2.accounting.model;

/**
 * Created by Администратор on 27.01.2016.
 */
public class TestInvoice {
    private Integer id;
    private Integer testProductId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestProductId() {
        return testProductId;
    }

    public void setTestProductId(Integer testProductId) {
        this.testProductId = testProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestInvoice that = (TestInvoice) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (testProductId != null ? !testProductId.equals(that.testProductId) : that.testProductId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (testProductId != null ? testProductId.hashCode() : 0);
        return result;
    }
}
