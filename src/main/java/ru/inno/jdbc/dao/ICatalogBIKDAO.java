package ru.inno.jdbc.dao;

import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.pojo.*;

import java.util.ArrayList;

public interface ICatalogBIKDAO {

    Integer add(CatalogBIK catalog) throws CatalogBIKDAOException;

    Integer update(CatalogBIK catalog, Integer id) throws CatalogBIKDAOException;

    void deleteAll() throws CatalogBIKDAOException;

    ArrayList<CatalogBIK> getByValue(String type, String value) throws CatalogBIKDAOException;

    CatalogBIK getById(String id) throws CatalogBIKDAOException;

    CatalogBIK getByIdPnzRegTnpUer(String id) throws CatalogBIKDAOException;

    void addAll(ArrayList<CatalogBIK> catalog) throws CatalogBIKDAOException;

    void deleteById(Integer id) throws CatalogBIKDAOException;
}
