package ru.inno.jdbc.exception;

import org.apache.log4j.Logger;

public class CatalogUERDAOException extends ExceptionDAO {

    private static final Logger logger = Logger.getLogger(CatalogUERDAOException.class);

    public CatalogUERDAOException() {
    }

    public CatalogUERDAOException(String message) {
        super(message);
    }

    public CatalogUERDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogUERDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CatalogUERDAOException(Throwable cause) {
        super(cause);
    }
}
