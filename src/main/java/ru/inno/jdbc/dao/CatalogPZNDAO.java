package ru.inno.jdbc.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.inno.Constants;
import ru.inno.jdbc.connection.IConnectionFactory;
import ru.inno.jdbc.connection.mysql.ConnectionFactory;
import ru.inno.jdbc.exception.CatalogPZNDAOException;
import ru.inno.pojo.CatalogPZN;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Класс, реализующий методы, которые используются при взаимодействии с таблицей БД pzn
 */
@Repository
public class CatalogPZNDAO implements ICatalogPZNDAO {
    private static final Logger logger = Logger.getLogger(CatalogPZNDAO.class);
    private static IConnectionFactory connection;

    static {
        connection = ConnectionFactory.getInstance();
    }

    @Override
    public void addAll(ArrayList<CatalogPZN> catalogs) throws CatalogPZNDAOException {
        String sql = "INSERT INTO pzn (pzn, imy, name, cb_date, ce_date) VALUES(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);) {
            preparedStatement.clearParameters();
            for (CatalogPZN catalog : catalogs) {
                preparedStatement.setInt(1, catalog.getPzn().equals("") ? " ".hashCode() : catalog.getPzn().hashCode());
                preparedStatement.setString(2, catalog.getImy());
                preparedStatement.setString(3, catalog.getName());
                preparedStatement.setDate(4, Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getCb_date().getTime())));
                preparedStatement.setDate(5, catalog.getCe_date().getTime() == Constants.DATE_NULL ? null : Date.valueOf(String.format("%1$tY-%1$tm-%1$td", catalog.getCe_date())));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogPZNDAOException();
        }
    }

    @Override
    public TreeSet<CatalogPZN> getOnlyPznAndName() throws CatalogPZNDAOException {
        TreeSet<CatalogPZN> fields = new TreeSet<>();
        try (Statement statement = connection.getConnection().createStatement();) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT pzn, name FROM pzn");
            while (resultSet.next()) {
                CatalogPZN catalogPZN = new CatalogPZN(
                        String.valueOf(resultSet.getInt("pzn")),
                        resultSet.getString("name"));
                fields.add(catalogPZN);
            }
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogPZNDAOException();
        }
        return fields;
    }

    @Override
    public void deleteAll() throws CatalogPZNDAOException {
        try (Statement statement = connection.getConnection().createStatement()) {
            statement.execute("DELETE FROM pzn");
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogPZNDAOException();
        }
    }
}