package ru.inno;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Класс констант
 */
@Component
public class Constants {
    public static final String URL_FILES = "dbf" + File.separator;
    public static final String URL_FILE_BIK = URL_FILES + "BNKSEEK.DBF";
    public static final String URL_FILE_PZN = URL_FILES + "PZN.DBF";
    public static final String URL_FILE_RGN = URL_FILES + "REG.DBF";
    public static final String URL_FILE_TNP = URL_FILES + "TNP.DBF";
    public static final String URL_FILE_UER = URL_FILES + "UER.DBF";
    public static final Long DATE_NULL = -623616116400000l;
    public static final int DUPLICATE_ENTRY = 1062;

    public Constants() throws IOException {
    }
}