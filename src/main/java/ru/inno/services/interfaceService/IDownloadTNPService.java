package ru.inno.services.interfaceService;

import ru.inno.jdbc.exception.CatalogTNPDAOException;
import ru.inno.pojo.CatalogTNP;

import java.util.TreeSet;

public interface IDownloadTNPService {
    TreeSet<CatalogTNP> getTNP(String arg) throws CatalogTNPDAOException;
}
