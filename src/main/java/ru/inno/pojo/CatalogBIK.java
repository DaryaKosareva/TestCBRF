package ru.inno.pojo;

import java.util.Date;

/**
 * Класс, описывающий БИК
 */
public class CatalogBIK implements Comparable {
    private Integer id;
    private String real;
    private String pzn;
    private String uer;
    private String rgn;
    private String ind;
    private String tnp;
    private String nnp;
    private String adr;
    private String rkc;
    private String namep;
    private String newnum;
    private String telef;
    private String regn;
    private String okpo;
    private Date dt_izm;
    private String ksnp;
    private Date date_in;
    private Date date_ch;

    public CatalogBIK() {
    }

    public CatalogBIK(String pzn, String uer, String rgn, String tnp) {
        this.pzn = pzn;
        this.uer = uer;
        this.rgn = rgn;
        this.tnp = tnp;
    }

    public CatalogBIK(String real, String pzn, String uer, String rgn, String ind, String tnp, String nnp, String adr,
                      String rkc, String namep, String newnum, String telef, String regn, String okpo,
                      Date dt_izm, String ksnp, Date date_in, Date date_ch) {
        this.real = real;
        this.pzn = pzn;
        this.uer = uer;
        this.rgn = rgn;
        this.ind = ind;
        this.tnp = tnp;
        this.nnp = nnp;
        this.adr = adr;
        this.rkc = rkc;
        this.namep = namep;
        this.newnum = newnum;
        this.telef = telef;
        this.regn = regn;
        this.okpo = okpo;
        this.dt_izm = dt_izm;
        this.ksnp = ksnp;
        this.date_in = date_in;
        this.date_ch = date_ch;
    }

    public CatalogBIK(Integer id, String real, String pzn, String uer, String rgn, String ind,
                      String tnp, String nnp, String adr, String rkc, String namep, String newnum,
                       String telef, String regn, String okpo, Date dt_izm, String ksnp,
                      Date date_in, Date date_ch) {
        this.id = id;
        this.real = real;
        this.pzn = pzn;
        this.uer = uer;
        this.rgn = rgn;
        this.ind = ind;
        this.tnp = tnp;
        this.nnp = nnp;
        this.adr = adr;
        this.rkc = rkc;
        this.namep = namep;
        this.newnum = newnum;
        this.telef = telef;
        this.regn = regn;
        this.okpo = okpo;
        this.dt_izm = dt_izm;
        this.ksnp = ksnp;
        this.date_in = date_in;
        this.date_ch = date_ch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public String getPzn() {
        return pzn;
    }

    public void setPzn(String pzn) {
        this.pzn = pzn;
    }

    public String getUer() {
        return uer;
    }

    public void setUer(String uer) {
        this.uer = uer;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getRkc() {
        return rkc;
    }

    public void setRkc(String rkc) {
        this.rkc = rkc;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getNewnum() {
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum;
    }


    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getRegn() {
        return regn;
    }

    public void setRegn(String regn) {
        this.regn = regn;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public Date getDt_izm() {
        return dt_izm;
    }

    public void setDt_izm(Date dt_izm) {
        this.dt_izm = dt_izm;
    }

    public String getKsnp() {
        return ksnp;
    }

    public void setKsnp(String ksnp) {
        this.ksnp = ksnp;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getDate_ch() {
        return date_ch;
    }

    public void setDate_ch(Date date_ch) {
        this.date_ch = date_ch;
    }

    public CatalogBIK(String namep,String real, String pzn, String uer, String rgn, String tnp,Date date_in,Date date_ch, Date dt_izm) {
        this.namep = namep;
        this.real = real;
        this.pzn = pzn;
        this.uer = uer;
        this.rgn = rgn;
        this.tnp = tnp;
    }

    @Override
    public String toString() {
        return "CatalogBIK{" +
                "id=" + id +
                ", real='" + real + '\'' +
                ", pzn='" + pzn + '\'' +
                ", uer='" + uer + '\'' +
                ", rgn='" + rgn + '\'' +
                ", ind='" + ind + '\'' +
                ", tnp='" + tnp + '\'' +
                ", nnp='" + nnp + '\'' +
                ", adr='" + adr + '\'' +
                ", rkc='" + rkc + '\'' +
                ", namep='" + namep + '\'' +
                ", newnum='" + newnum + '\'' +
                ", telef='" + telef + '\'' +
                ", regn='" + regn + '\'' +
                ", okpo='" + okpo + '\'' +
                ", dt_izm=" + dt_izm +
                ", ksnp='" + ksnp + '\'' +
                ", date_in=" + date_in +
                ", date_ch=" + date_ch +
                '}';
    }

    @Override
    public int compareTo(Object t) {

        if (t instanceof CatalogBIK) {
            CatalogBIK s = (CatalogBIK) t;
            return (this.newnum.compareTo(s.newnum));
        } else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogBIK)) return false;

        CatalogBIK that = (CatalogBIK) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getReal() != null ? !getReal().equals(that.getReal()) : that.getReal() != null) return false;
        if (getPzn() != null ? !getPzn().equals(that.getPzn()) : that.getPzn() != null) return false;
        if (getUer() != null ? !getUer().equals(that.getUer()) : that.getUer() != null) return false;
        if (getRgn() != null ? !getRgn().equals(that.getRgn()) : that.getRgn() != null) return false;
        if (getInd() != null ? !getInd().equals(that.getInd()) : that.getInd() != null) return false;
        if (getTnp() != null ? !getTnp().equals(that.getTnp()) : that.getTnp() != null) return false;
        if (getNnp() != null ? !getNnp().equals(that.getNnp()) : that.getNnp() != null) return false;
        if (getAdr() != null ? !getAdr().equals(that.getAdr()) : that.getAdr() != null) return false;
        if (getRkc() != null ? !getRkc().equals(that.getRkc()) : that.getRkc() != null) return false;
        if (getNamep() != null ? !getNamep().equals(that.getNamep()) : that.getNamep() != null) return false;
        if (!getNewnum().equals(that.getNewnum())) return false;
        if (getTelef() != null ? !getTelef().equals(that.getTelef()) : that.getTelef() != null) return false;
        if (getRegn() != null ? !getRegn().equals(that.getRegn()) : that.getRegn() != null) return false;
        if (getOkpo() != null ? !getOkpo().equals(that.getOkpo()) : that.getOkpo() != null) return false;
        if (getDt_izm() != null ? !getDt_izm().equals(that.getDt_izm()) : that.getDt_izm() != null) return false;
        if (getKsnp() != null ? !getKsnp().equals(that.getKsnp()) : that.getKsnp() != null) return false;
        if (getDate_in() != null ? !getDate_in().equals(that.getDate_in()) : that.getDate_in() != null) return false;
        return getDate_ch() != null ? getDate_ch().equals(that.getDate_ch()) : that.getDate_ch() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getReal() != null ? getReal().hashCode() : 0);
        result = 31 * result + (getPzn() != null ? getPzn().hashCode() : 0);
        result = 31 * result + (getUer() != null ? getUer().hashCode() : 0);
        result = 31 * result + (getRgn() != null ? getRgn().hashCode() : 0);
        result = 31 * result + (getInd() != null ? getInd().hashCode() : 0);
        result = 31 * result + (getTnp() != null ? getTnp().hashCode() : 0);
        result = 31 * result + (getNnp() != null ? getNnp().hashCode() : 0);
        result = 31 * result + (getAdr() != null ? getAdr().hashCode() : 0);
        result = 31 * result + (getRkc() != null ? getRkc().hashCode() : 0);
        result = 31 * result + (getNamep() != null ? getNamep().hashCode() : 0);
        result = 31 * result + getNewnum().hashCode();
        result = 31 * result + (getTelef() != null ? getTelef().hashCode() : 0);
        result = 31 * result + (getRegn() != null ? getRegn().hashCode() : 0);
        result = 31 * result + (getOkpo() != null ? getOkpo().hashCode() : 0);
        result = 31 * result + (getDt_izm() != null ? getDt_izm().hashCode() : 0);
        result = 31 * result + (getKsnp() != null ? getKsnp().hashCode() : 0);
        result = 31 * result + (getDate_in() != null ? getDate_in().hashCode() : 0);
        result = 31 * result + (getDate_ch() != null ? getDate_ch().hashCode() : 0);
        return result;
    }
}
