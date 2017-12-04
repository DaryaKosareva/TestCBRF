package ru.inno.services.interfaceService;

import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.pojo.CatalogBIK;

import java.util.ArrayList;

public interface IDownloadBIKService {

    ArrayList<CatalogBIK> getBIK(String type, String value) throws CatalogBIKDAOException;

    CatalogBIK getByIdBIK(String id) throws CatalogBIKDAOException;

    CatalogBIK getByIdPnzRegTnpUer(String id) throws CatalogBIKDAOException;
}
