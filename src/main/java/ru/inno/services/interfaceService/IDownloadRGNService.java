package ru.inno.services.interfaceService;

import ru.inno.jdbc.exception.CatalogRGNDAOException;
import ru.inno.pojo.CatalogRGN;

import java.util.TreeSet;

public interface IDownloadRGNService {

    TreeSet<CatalogRGN> getRGN(String arg) throws CatalogRGNDAOException;
}
