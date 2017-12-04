package ru.inno.pojo;

import java.util.Date;

/**
 * Класс, описывающий тип участника раcчетов
 */
public class CatalogPZN implements Comparable {
    private Integer id;
    private String pzn;
    private String imy;
    private String name;
    private Date cb_date;
    private Date ce_date;

    public CatalogPZN() {
    }

    public CatalogPZN(String pzn, String name) {
        this.pzn = pzn;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPzn() {
        return pzn;
    }

    public void setPzn(String pzn) {
        this.pzn = pzn;
    }

    public String getImy() {
        return imy;
    }

    public void setImy(String imy) {
        this.imy = imy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCb_date() {
        return cb_date;
    }

    public void setCb_date(Date cb_date) {
        this.cb_date = cb_date;
    }

    public Date getCe_date() {
        return ce_date;
    }

    public void setCe_date(Date ce_date) {
        this.ce_date = ce_date;
    }

    @Override
    public int compareTo(Object t) {

        if (t instanceof CatalogPZN) {
            CatalogPZN s = (CatalogPZN) t;
            return (this.name.compareTo(s.name));
        } else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogPZN)) return false;

        CatalogPZN that = (CatalogPZN) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPzn() != null ? !getPzn().equals(that.getPzn()) : that.getPzn() != null) return false;
        if (getImy() != null ? !getImy().equals(that.getImy()) : that.getImy() != null) return false;
        if (!getName().equals(that.getName())) return false;
        if (getCb_date() != null ? !getCb_date().equals(that.getCb_date()) : that.getCb_date() != null) return false;
        return getCe_date() != null ? getCe_date().equals(that.getCe_date()) : that.getCe_date() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPzn() != null ? getPzn().hashCode() : 0);
        result = 31 * result + (getImy() != null ? getImy().hashCode() : 0);
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getCb_date() != null ? getCb_date().hashCode() : 0);
        result = 31 * result + (getCe_date() != null ? getCe_date().hashCode() : 0);
        return result;
    }
}
