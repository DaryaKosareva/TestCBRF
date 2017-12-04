package ru.inno.pojo;

/**
 * Класс, описывающий территорию РФ
 */
public class CatalogRGN implements Comparable {
    private Integer id;
    private String rgn;
    private String name;
    private String center;
    private String namet;

    public CatalogRGN() {
    }

    public CatalogRGN(String rgn, String name) {
        this.rgn = rgn;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getNamet() {
        return namet;
    }

    public void setNamet(String namet) {
        this.namet = namet;
    }

    @Override
    public int compareTo(Object t) {

        if (t instanceof CatalogRGN) {
            CatalogRGN s = (CatalogRGN) t;
            return (this.name.compareTo(s.name));
        } else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogRGN)) return false;

        CatalogRGN that = (CatalogRGN) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getRgn() != null ? !getRgn().equals(that.getRgn()) : that.getRgn() != null) return false;
        if (!getName().equals(that.getName())) return false;
        if (getCenter() != null ? !getCenter().equals(that.getCenter()) : that.getCenter() != null) return false;
        return getNamet() != null ? getNamet().equals(that.getNamet()) : that.getNamet() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRgn() != null ? getRgn().hashCode() : 0);
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getCenter() != null ? getCenter().hashCode() : 0);
        result = 31 * result + (getNamet() != null ? getNamet().hashCode() : 0);
        return result;
    }
}