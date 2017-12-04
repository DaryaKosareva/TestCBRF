package ru.inno.services.interfaceService;

import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.pojo.CatalogBIK;

public interface IAddBIKService {
    String addBIK(CatalogBIK catalogBIK) throws CatalogBIKDAOException;
}
