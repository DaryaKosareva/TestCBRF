package ru.inno.jdbc.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.inno.jdbc.connection.IConnectionFactory;
import ru.inno.jdbc.connection.mysql.ConnectionFactory;
import ru.inno.jdbc.exception.CatalogUERDAOException;
import ru.inno.pojo.CatalogUER;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Класс, реализующий методы, которые используются при взаимодействии с таблицей БД uer
 */
@Repository
public class CatalogUERDAO implements ICatalogUERDAO {
    private static final Logger logger = Logger.getLogger(CatalogUERDAO.class);
    private static IConnectionFactory connection;

    static {
        connection = ConnectionFactory.getInstance();
    }

    @Override
    public void addAll(ArrayList<CatalogUER> catalogs) throws CatalogUERDAOException {
        String sql = "INSERT INTO uer (uer, uername) VALUES(?,?)";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);) {
            preparedStatement.clearParameters();
            for (CatalogUER catalog : catalogs) {
                preparedStatement.setInt(1, catalog.getUer().hashCode());
                preparedStatement.setString(2, catalog.getUername());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogUERDAOException();
        }
    }

    @Override
    public TreeSet<CatalogUER> getOnlyUerAndName() throws CatalogUERDAOException {
        TreeSet<CatalogUER> fields = new TreeSet<>();
        try (Statement statement = connection.getConnection().createStatement();) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT uer, uername FROM uer");
            while (resultSet.next()) {
                CatalogUER catalogUER = new CatalogUER(
                        String.valueOf(resultSet.getInt("uer")),
                        resultSet.getString("uername"));
                fields.add(catalogUER);
            }
        } catch (SQLException e) {
            logger.error((e.getMessage()));
            throw new CatalogUERDAOException();
        }
        return fields;
    }

    @Override
    public void deleteAll() throws CatalogUERDAOException {
        try (Statement statement = connection.getConnection().createStatement()) {
            statement.execute("DELETE FROM uer");
        } catch (SQLException e) {
            logger.error("SQLState: " + e.getSQLState() + " Message: " + e.getMessage() + " Code: " + e.getErrorCode());
            throw new CatalogUERDAOException();
        }
    }
}
