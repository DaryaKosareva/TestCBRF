package ru.inno.pojo;

/**
 * Класс, описывающий тип участника/пользователя системы электронных расчетов
 */
public class CatalogUER implements Comparable {
    private Integer id;
    private String uer;
    private String uername;

    public CatalogUER() {
    }

    public CatalogUER(String uer, String uername) {
        this.uer = uer;
        this.uername = uername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUer() {
        return uer;
    }

    public void setUer(String uer) {
        this.uer = uer;
    }

    public String getUername() {
        return uername;
    }

    public void setUername(String uername) {
        this.uername = uername;
    }

    @Override
    public int compareTo(Object t) {

        if (t instanceof CatalogUER) {
            CatalogUER s = (CatalogUER) t;
            return (this.uername.compareTo(s.uername));
        } else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogUER)) return false;

        CatalogUER that = (CatalogUER) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getUer() != null ? !getUer().equals(that.getUer()) : that.getUer() != null) return false;
        return getUername().equals(that.getUername());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUer() != null ? getUer().hashCode() : 0);
        result = 31 * result + getUername().hashCode();
        return result;
    }
}
