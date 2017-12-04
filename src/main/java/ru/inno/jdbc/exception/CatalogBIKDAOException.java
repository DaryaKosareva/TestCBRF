package ru.inno.jdbc.exception;

import org.apache.log4j.Logger;

public class CatalogBIKDAOException extends ExceptionDAO {

    private static final Logger logger = Logger.getLogger(CatalogBIKDAOException.class);

    public CatalogBIKDAOException() {
    }

    public CatalogBIKDAOException(String message) {
        super(message);
    }

    public CatalogBIKDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogBIKDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CatalogBIKDAOException(Throwable cause) {
        super(cause);
    }
}
