package ru.inno.jdbc.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.inno.Constants;
import ru.inno.jdbc.connection.IConnectionFactory;
import ru.inno.jdbc.connection.mysql.ConnectionFactory;
import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.pojo.CatalogBIK;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс, реализующий методы, которые используются при взаимодействии с таблицей БД bnkseek
 */
@Repository
public class CatalogBIKDAO implements ICatalogBIKDAO {
    private static final Logger logger = Logger.getLogger(CatalogBIKDAO.class);
    private static IConnectionFactory connection;

    static {
        connection = ConnectionFactory.getInstance();
    }

    @Override
    public Integer add(CatalogBIK catalog) throws CatalogBIKDAOException {
        Integer code;
        String sql = "INSERT INTO bnkseek (real_bik, pzn, uer, rgn, ind, tnp, nnp," +
                "                     adr, rkc, namep, newnum, telef, regn," +
                "                     okpo, dt_izm, ksnp, date_in, date_ch)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql)) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, catalog.getReal());
            preparedStatement.setInt(2, catalog.getPzn().equals("") ? 0 : Integer.parseInt(catalog.getPzn()));
            preparedStatement.setInt(3, Integer.parseInt(catalog.getUer()));
            preparedStatement.setInt(4, Integer.parseInt(catalog.getRgn()));
            preparedStatement.setString(5, catalog.getInd());
            preparedStatement.setInt(6, catalog.getTnp().equals("") ? 0 : Integer.parseInt(catalog.getTnp()));
            preparedStatement.setString(7, catalog.getNnp());
            preparedStatement.setString(8, catalog.getAdr());
            preparedStatement.setString(9, catalog.getRkc());
            preparedStatement.setString(10, catalog.getNamep());
            preparedStatement.setString(11, catalog.getNewnum());
            preparedStatement.setString(12, catalog.getTelef());
            preparedStatement.setString(13, catalog.getRegn());
            preparedStatement.setString(14, catalog.getOkpo());
            preparedStatement.setDate(15, Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDt_izm().getTime())));
            preparedStatement.setString(16, catalog.getKsnp());
            preparedStatement.setDate(17, Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDate_in().getTime())));
            preparedStatement.setDate(18, catalog.getDate_ch() == null ? null : Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDate_ch())));
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            code = 0;
        } catch (SQLException e) {
            code = e.getErrorCode();
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
        }
        return code;
    }

    @Override
    public Integer update(CatalogBIK catalog, Integer id) throws CatalogBIKDAOException {
        Integer code;
        String sql = "UPDATE bnkseek SET real_bik=?, pzn=?, uer=?, rgn=?, ind=?, tnp=?, nnp=?, " +
                "       adr=?, rkc=?, namep=?, newnum=?, telef=?, regn=?, " +
                "       okpo=?, dt_izm=?, ksnp=?, date_in=?, date_ch=? " +
                "WHERE id=?";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql)) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, catalog.getReal());
            preparedStatement.setInt(2, catalog.getPzn().equals("") ? 0 : Integer.parseInt(catalog.getPzn()));
            preparedStatement.setInt(3, Integer.parseInt(catalog.getUer()));
            preparedStatement.setInt(4, Integer.parseInt(catalog.getRgn()));
            preparedStatement.setString(5, catalog.getInd());
            preparedStatement.setInt(6, catalog.getTnp().equals("") ? 0 : Integer.parseInt(catalog.getTnp()));
            preparedStatement.setString(7, catalog.getNnp());
            preparedStatement.setString(8, catalog.getAdr());
            preparedStatement.setString(9, catalog.getRkc());
            preparedStatement.setString(10, catalog.getNamep());
            preparedStatement.setString(11, catalog.getNewnum());
            preparedStatement.setString(12, catalog.getTelef());
            preparedStatement.setString(13, catalog.getRegn());
            preparedStatement.setString(14, catalog.getOkpo());
            preparedStatement.setDate(15, Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDt_izm().getTime())));
            preparedStatement.setString(16, catalog.getKsnp());
            preparedStatement.setDate(17, Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDate_in().getTime())));
            preparedStatement.setDate(18, catalog.getDate_ch() == null ? null : Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDate_ch())));
            preparedStatement.setInt(19, id);
            preparedStatement.addBatch();

            preparedStatement.executeUpdate();
            code = 0;
        } catch (SQLException e) {
            code = e.getErrorCode();
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
        }
        return code;
    }

    @Override
    public void deleteById(Integer id) throws CatalogBIKDAOException {
        String sql = "DELETE FROM bnkseek WHERE id = ? ";
        try (PreparedStatement statement = connection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogBIKDAOException();
        }
    }

    @Override
    public void deleteAll() throws CatalogBIKDAOException {
        try (Statement statement = connection.getConnection().createStatement()) {
            statement.execute("DELETE FROM bnkseek");
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogBIKDAOException();
        }
    }

    @Override
    public ArrayList<CatalogBIK> getByValue(String type, String value) throws CatalogBIKDAOException {
        ArrayList<CatalogBIK> catalogBIKList = new ArrayList<>();
        String conditionWhere = "";
        if (type.equals("byBik")) {
            conditionWhere = "WHERE bnkseek.newnum LIKE \"%" + value + "%\"";
        } else if (type.equals("byRgn")) {
            conditionWhere = "WHERE reg.name LIKE \"%" + value + "%\" OR reg.center LIKE \"%" + value + "%\"";
        } else if (type.equals("byPzn")) {
            conditionWhere = "WHERE pzn.pzn LIKE \"%" + value + "%\"";
        } else if (type.equals("all")) {
            conditionWhere = "";
        }
        try (Statement statement = connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT *" +
                            "FROM (((bnkseek" +
                            "  LEFT JOIN pzn ON bnkseek.pzn = pzn.pzn)" +
                            "  LEFT JOIN tnp ON bnkseek.tnp = tnp.tnp)" +
                            "  LEFT JOIN reg ON bnkseek.rgn = reg.rgn)" +
                            "  LEFT JOIN uer ON bnkseek.uer = uer.uer " + conditionWhere);
            while (resultSet.next()) {
                CatalogBIK catalogBIK = new CatalogBIK(
                        resultSet.getInt("id"),
                        resultSet.getString("bnkseek.real_bik"),
                        resultSet.getString("pzn.name"),
                        resultSet.getString("uer.uername"),
                        resultSet.getString("reg.name") + " " + resultSet.getString("reg.center"),
                        resultSet.getString("bnkseek.ind"),
                        resultSet.getString("tnp.fullname"),
                        resultSet.getString("bnkseek.nnp"),
                        resultSet.getString("bnkseek.adr"),
                        resultSet.getString("bnkseek.rkc"),
                        resultSet.getString("bnkseek.namep"),
                        resultSet.getString("bnkseek.newnum"),
                        resultSet.getString("bnkseek.telef"),
                        resultSet.getString("bnkseek.regn"),
                        resultSet.getString("bnkseek.okpo"),
                        resultSet.getDate("bnkseek.dt_izm"),
                        resultSet.getString("bnkseek.ksnp"),
                        resultSet.getDate("bnkseek.date_in"),
                        resultSet.getDate("bnkseek.date_ch")
                );
                catalogBIKList.add(catalogBIK);
            }
            Collections.sort(catalogBIKList);
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogBIKDAOException();
        }
        return catalogBIKList;
    }

    @Override
    public CatalogBIK getByIdPnzRegTnpUer(String id) throws CatalogBIKDAOException {
        CatalogBIK catalog = null;
        try (Statement statement = connection.getConnection().createStatement();) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT *" +
                            "FROM (((bnkseek" +
                            "  LEFT JOIN pzn ON bnkseek.pzn = pzn.pzn)" +
                            "  LEFT JOIN tnp ON bnkseek.tnp = tnp.tnp)" +
                            "  LEFT JOIN reg ON bnkseek.rgn = reg.rgn)" +
                            "  LEFT JOIN uer ON bnkseek.uer = uer.uer " +
                            "WHERE bnkseek.id = " + id);
            while (resultSet.next()) {
                catalog = new CatalogBIK(
                        resultSet.getString("pzn.pzn"),
                        resultSet.getString("uer.uer"),
                        resultSet.getString("reg.rgn"),
                        resultSet.getString("tnp.tnp")
                );
                return catalog;
            }
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogBIKDAOException();
        }
        return catalog;
    }

    @Override
    public CatalogBIK getById(String id) throws CatalogBIKDAOException {
        CatalogBIK catalog = null;
        try (Statement statement = connection.getConnection().createStatement();) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT *" +
                            "FROM (((bnkseek" +
                            "  LEFT JOIN pzn ON bnkseek.pzn = pzn.pzn)" +
                            "  LEFT JOIN tnp ON bnkseek.tnp = tnp.tnp)" +
                            "  LEFT JOIN reg ON bnkseek.rgn = reg.rgn)" +
                            "  LEFT JOIN uer ON bnkseek.uer = uer.uer " +
                            "WHERE bnkseek.id = " + id);
            while (resultSet.next()) {
                catalog = new CatalogBIK(
                        resultSet.getInt("id"),
                        resultSet.getString("bnkseek.real_bik"),
                        resultSet.getString("pzn.name"),
                        resultSet.getString("uer.uername"),
                        resultSet.getString("reg.name") + " " + resultSet.getString("reg.center"),
                        resultSet.getString("bnkseek.ind"),
                        resultSet.getString("tnp.fullname"),
                        resultSet.getString("bnkseek.nnp"),
                        resultSet.getString("bnkseek.adr"),
                        resultSet.getString("bnkseek.rkc"),
                        resultSet.getString("bnkseek.namep"),
                        resultSet.getString("bnkseek.newnum"),
                        resultSet.getString("bnkseek.telef"),
                        resultSet.getString("bnkseek.regn"),
                        resultSet.getString("bnkseek.okpo"),
                        resultSet.getDate("bnkseek.dt_izm"),
                        resultSet.getString("bnkseek.ksnp"),
                        resultSet.getDate("bnkseek.date_in"),
                        resultSet.getDate("bnkseek.date_ch")
                );
                return catalog;
            }
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogBIKDAOException();
        }
        return catalog;
    }

    @Override
    public void addAll(ArrayList<CatalogBIK> catalogs) throws CatalogBIKDAOException {

        String sql = "INSERT INTO bnkseek (real_bik, pzn, uer, rgn, ind, tnp, nnp, adr, rkc, namep, newnum, telef, regn, okpo, dt_izm, ksnp, date_in, date_ch) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql)) {
            preparedStatement.clearParameters();
            for (CatalogBIK catalog : catalogs) {
                preparedStatement.setString(1, catalog.getReal());
                preparedStatement.setInt(2, catalog.getPzn().hashCode());
                preparedStatement.setInt(3, catalog.getUer().hashCode());
                preparedStatement.setInt(4, catalog.getRgn().hashCode());
                preparedStatement.setString(5, catalog.getInd());
                preparedStatement.setInt(6, catalog.getTnp().hashCode());
                preparedStatement.setString(7, catalog.getNnp());
                preparedStatement.setString(8, catalog.getAdr());
                preparedStatement.setString(9, catalog.getRkc());
                preparedStatement.setString(10, catalog.getNamep());
                preparedStatement.setString(11, catalog.getNewnum());
                preparedStatement.setString(12, catalog.getTelef());
                preparedStatement.setString(13, catalog.getRegn());
                preparedStatement.setString(14, catalog.getOkpo());
                preparedStatement.setDate(15, Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDt_izm().getTime())));
                preparedStatement.setString(16, catalog.getKsnp());
                preparedStatement.setDate(17, Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDate_in().getTime())));
                preparedStatement.setDate(18, catalog.getDate_ch().getTime() == Constants.DATE_NULL ? null : Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getDate_ch())));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogBIKDAOException();
        }
    }
}