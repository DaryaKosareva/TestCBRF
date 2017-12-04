package ru.inno.jdbc.exception;

import org.apache.log4j.Logger;

public class CatalogTNPDAOException extends ExceptionDAO {

    private static final Logger logger = Logger.getLogger(CatalogTNPDAOException.class);

    public CatalogTNPDAOException() {
    }

    public CatalogTNPDAOException(String message) {
        super(message);
    }

    public CatalogTNPDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogTNPDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CatalogTNPDAOException(Throwable cause) {
        super(cause);
    }
}
