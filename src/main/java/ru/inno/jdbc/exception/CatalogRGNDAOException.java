package ru.inno.jdbc.exception;

import org.apache.log4j.Logger;

public class CatalogRGNDAOException extends ExceptionDAO {

    private static final Logger logger = Logger.getLogger(CatalogRGNDAOException.class);

    public CatalogRGNDAOException() {
    }

    public CatalogRGNDAOException(String message) {
        super(message);
    }

    public CatalogRGNDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogRGNDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CatalogRGNDAOException(Throwable cause) {
        super(cause);
    }
}
