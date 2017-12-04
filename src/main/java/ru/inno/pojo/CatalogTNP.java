package ru.inno.pojo;

/**
 * Класс, описывающий тип населенного пункта
 */
public class CatalogTNP implements Comparable {
    private Integer id;
    private String tnp;
    private String fullname;
    private String shortname;

    public CatalogTNP() {
    }

    public CatalogTNP(String tnp, String fullname) {
        this.tnp = tnp;
        this.fullname = fullname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public int compareTo(Object t) {

        if (t instanceof CatalogTNP) {
            CatalogTNP s = (CatalogTNP) t;
            return (this.fullname.compareTo(s.fullname));
        } else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogTNP)) return false;

        CatalogTNP that = (CatalogTNP) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getTnp() != null ? !getTnp().equals(that.getTnp()) : that.getTnp() != null) return false;
        if (!getFullname().equals(that.getFullname())) return false;
        return getShortname() != null ? getShortname().equals(that.getShortname()) : that.getShortname() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTnp() != null ? getTnp().hashCode() : 0);
        result = 31 * result + getFullname().hashCode();
        result = 31 * result + (getShortname() != null ? getShortname().hashCode() : 0);
        return result;
    }
}
