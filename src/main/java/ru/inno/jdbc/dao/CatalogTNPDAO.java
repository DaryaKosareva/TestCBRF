package ru.inno.jdbc.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.inno.jdbc.connection.IConnectionFactory;
import ru.inno.jdbc.connection.mysql.ConnectionFactory;
import ru.inno.jdbc.exception.CatalogTNPDAOException;
import ru.inno.pojo.CatalogTNP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Класс, реализующий методы, которые используются при взаимодействии с таблицей БД tnp
 */
@Repository
public class CatalogTNPDAO implements ICatalogTNPDAO {
    private static final Logger logger = Logger.getLogger(CatalogTNPDAO.class);
    private static IConnectionFactory connection;

    static {
        connection = ConnectionFactory.getInstance();
    }

    @Override
    public void addAll(ArrayList<CatalogTNP> catalogs) throws CatalogTNPDAOException {
        String sql = "INSERT INTO tnp (tnp, fullname, shortname) VALUES(?,?,?)";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);) {
            preparedStatement.clearParameters();
            for (CatalogTNP catalog : catalogs) {
                preparedStatement.setInt(1, catalog.getTnp().equals("") ? " ".hashCode() : catalog.getTnp().hashCode());
                preparedStatement.setString(2, catalog.getFullname());
                preparedStatement.setString(3, catalog.getShortname());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogTNPDAOException();
        }
    }

    @Override
    public TreeSet<CatalogTNP> getOnlyTnpAndName() throws CatalogTNPDAOException {
        TreeSet<CatalogTNP> fields = new TreeSet<>();
        try (Statement statement = connection.getConnection().createStatement();) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT tnp, fullname FROM tnp");
            while (resultSet.next()) {
                CatalogTNP catalogTNP = new CatalogTNP(
                        String.valueOf(resultSet.getInt("tnp")),
                        resultSet.getString("fullname"));
                fields.add(catalogTNP);
            }
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogTNPDAOException();
        }
        return fields;
    }

    @Override
    public void deleteAll() throws CatalogTNPDAOException {
        try (Statement statement = connection.getConnection().createStatement()) {
            statement.execute("DELETE FROM tnp");
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogTNPDAOException();
        }
    }
}
