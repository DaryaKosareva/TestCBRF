package ru.inno.jdbc.dao;

import ru.inno.jdbc.exception.CatalogTNPDAOException;
import ru.inno.pojo.CatalogTNP;

import java.util.ArrayList;
import java.util.TreeSet;

public interface ICatalogTNPDAO {

    void addAll(ArrayList<CatalogTNP> catalog) throws CatalogTNPDAOException;

    TreeSet<CatalogTNP> getOnlyTnpAndName() throws CatalogTNPDAOException;

    void deleteAll() throws CatalogTNPDAOException;
}
