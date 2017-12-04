package ru.inno.jdbc.exception;

import org.apache.log4j.Logger;

public class ExceptionDAO extends Exception {

    private static final Logger logger = Logger.getLogger(ExceptionDAO.class);
    private String errorCode;
    private String errorMessage;

    public ExceptionDAO() {
        super();
    }

    public ExceptionDAO(String errorMessage) {
        super(errorMessage);
    }

    public ExceptionDAO(String errorCode, String errorMessage) {
        super(errorCode + ": " + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ExceptionDAO(String errorMessage, Throwable rootCause) {

        super(errorMessage, rootCause);
    }

    public ExceptionDAO(String errorMessage, Throwable cause, boolean enableSuppression,
                        boolean writableStackTrace) {
        super(errorMessage, cause, enableSuppression, writableStackTrace);
    }

    public ExceptionDAO(Throwable cause) {
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
