package ru.inno.services.interfaceService;

import ru.inno.jdbc.exception.CatalogPZNDAOException;
import ru.inno.pojo.CatalogPZN;

import java.util.TreeSet;

public interface IDownloadPZNService {

    TreeSet<CatalogPZN> getPZN(String arg) throws CatalogPZNDAOException;
}
