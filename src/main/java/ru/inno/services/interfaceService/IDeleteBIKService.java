package ru.inno.services.interfaceService;

import ru.inno.jdbc.exception.CatalogBIKDAOException;

public interface IDeleteBIKService {
    void deleteBIK(Integer id) throws CatalogBIKDAOException;
}
