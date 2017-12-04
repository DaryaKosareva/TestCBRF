package ru.inno.jdbc.dao;

import ru.inno.jdbc.exception.CatalogPZNDAOException;
import ru.inno.pojo.*;

import java.util.ArrayList;
import java.util.TreeSet;

public interface ICatalogPZNDAO {

    void addAll(ArrayList<CatalogPZN> catalog) throws CatalogPZNDAOException;


    TreeSet<CatalogPZN> getOnlyPznAndName() throws CatalogPZNDAOException;

    void deleteAll() throws CatalogPZNDAOException;
}
