package ru.inno.services.interfaceService;

import ru.inno.jdbc.exception.CatalogUERDAOException;
import ru.inno.pojo.CatalogUER;

import java.util.TreeSet;

public interface IDownloadUERService {
    TreeSet<CatalogUER> getUER(String arg) throws CatalogUERDAOException;
}
