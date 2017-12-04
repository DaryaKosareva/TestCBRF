package ru.inno.services.interfaceService;

import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.pojo.CatalogBIK;

public interface IEditBIKService {
    String editBIK(CatalogBIK catalogBIK, Integer id) throws CatalogBIKDAOException;
}
