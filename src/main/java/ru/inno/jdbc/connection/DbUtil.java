package ru.inno.jdbc.connection;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Класс с дополнительными методами для работы с БД
 */
public class DbUtil {
    private static final Logger logger = Logger.getLogger(DbUtil.class);

    /**
     * Проверяет является ли исключение типом WARNING
     *
     * @param warn - exception.
     */
    public static void checkWarnings(SQLWarning warn) {
        if (warn != null) {
            while (warn != null) {
                logger.warn(
                        "Unable to connect to database." + " SQLState: " + warn.getSQLState() + " Message: "
                                + warn.getMessage() + " Vendor code: " + warn.getErrorCode(), warn);
                warn.getNextException();
            }
        }
    }
}
