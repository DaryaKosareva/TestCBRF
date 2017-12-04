package ru.inno.services.interfaceService;

import java.util.ArrayList;

public interface IDbfFile {

    ArrayList getDataFile(Class myClass);

    void setDataFile(ArrayList dataFile);

    String getNameFile();

    void setNameFile(String nameFile);
}
