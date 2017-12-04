package ru.inno.jdbc.exception;

import org.apache.log4j.Logger;

public class CatalogPZNDAOException extends ExceptionDAO {

    private static final Logger logger = Logger.getLogger(CatalogPZNDAOException.class);

    public CatalogPZNDAOException() {
    }

    public CatalogPZNDAOException(String message) {
        super(message);
    }

    public CatalogPZNDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogPZNDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CatalogPZNDAOException(Throwable cause) {
        super(cause);
    }
}
