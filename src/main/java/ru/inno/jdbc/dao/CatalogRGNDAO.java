package ru.inno.jdbc.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.inno.jdbc.connection.IConnectionFactory;
import ru.inno.jdbc.connection.mysql.ConnectionFactory;
import ru.inno.jdbc.exception.CatalogRGNDAOException;
import ru.inno.pojo.CatalogRGN;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Класс, реализующий методы, которые используются при взаимодействии с таблицей БД reg
 */
@Repository
public class CatalogRGNDAO implements ICatalogRGNDAO {
    private static final Logger logger = Logger.getLogger(CatalogRGNDAO.class);
    private static IConnectionFactory connection;

    static {
        connection = ConnectionFactory.getInstance();
    }

    @Override
    public void addAll(ArrayList<CatalogRGN> catalogs) throws CatalogRGNDAOException {
        String sql = "INSERT INTO reg (rgn, name, center, namet) VALUES(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);) {
            preparedStatement.clearParameters();
            for (CatalogRGN catalog : catalogs) {
                preparedStatement.setInt(1, catalog.getRgn().hashCode());
                preparedStatement.setString(2, catalog.getName());
                preparedStatement.setString(3, catalog.getCenter());
                preparedStatement.setString(4, catalog.getNamet());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogRGNDAOException();
        }
    }

    @Override
    public TreeSet<CatalogRGN> getOnlyRgnAndName() throws CatalogRGNDAOException {
        TreeSet<CatalogRGN> fields = new TreeSet<>();
        try (Statement statement = connection.getConnection().createStatement();) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT rgn, name FROM reg");
            while (resultSet.next()) {
                CatalogRGN catalogRGN = new CatalogRGN(
                        String.valueOf(resultSet.getInt("rgn")),
                        resultSet.getString("name"));
                fields.add(catalogRGN);
            }
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogRGNDAOException();
        }
        return fields;
    }

    @Override
    public void deleteAll() throws CatalogRGNDAOException {
        try (Statement statement = connection.getConnection().createStatement()) {
            statement.execute("DELETE FROM reg");
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogRGNDAOException();
        }
    }
}
