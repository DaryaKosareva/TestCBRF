package ru.inno.jdbc.connection.mysql;

import org.apache.log4j.Logger;
import ru.inno.jdbc.connection.DbUtil;
import ru.inno.jdbc.connection.IConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для создания подключения к базе данных MySQL
 */
public class ConnectionFactory implements IConnectionFactory {
    private static final Logger logger = Logger.getLogger(ConnectionFactory.class);
    private static ConnectionFactory instance;
    public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private static final String URL_DB = "jdbc:mysql://localhost:3307/";
    private static final String DATABASE_NAME = "test_cbrf";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection createConnection(String url, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url + "?useSSL=false&characterEncoding=cp1251&useUnicode=true", user, password);
            DbUtil.checkWarnings(connection.getWarnings());
            logger.info("Connect to Database.");
        } catch (SQLException e) {
            logger.error(
                    "Unable to connect to database." + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage()
                            + " Vendor code: " + e.getErrorCode());
        } catch (Exception e) {
            logger.error("Unable to connect to database." + " Message: " + e.getMessage());
        }
        return connection;
    }

    @Override
    public Connection getConnection() {
        return instance.createConnection(URL_DB + DATABASE_NAME, USER, PASSWORD);
    }

    public static synchronized ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    private ConnectionFactory() {
        try {
            Class.forName(DRIVER_MYSQL);
        } catch (ClassNotFoundException e) {
            logger.error("Unable to load " + DRIVER_MYSQL, e.getException());
        } catch (Exception e) {
            logger.error("Unable to load " + DRIVER_MYSQL + " Message: " + e.getMessage());
        }
    }
}