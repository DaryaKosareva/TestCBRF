package ru.inno.jdbc.dao;

import ru.inno.jdbc.exception.CatalogUERDAOException;
import ru.inno.pojo.CatalogUER;

import java.util.ArrayList;
import java.util.TreeSet;

public interface ICatalogUERDAO {

    void addAll(ArrayList<CatalogUER> catalog) throws  CatalogUERDAOException;

    TreeSet<CatalogUER> getOnlyUerAndName() throws CatalogUERDAOException;

    void deleteAll() throws CatalogUERDAOException;
}
