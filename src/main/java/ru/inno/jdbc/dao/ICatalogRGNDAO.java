package ru.inno.jdbc.dao;

import ru.inno.jdbc.exception.CatalogRGNDAOException;
import ru.inno.pojo.*;

import java.util.ArrayList;
import java.util.TreeSet;

public interface ICatalogRGNDAO {

    void addAll(ArrayList<CatalogRGN> catalog) throws CatalogRGNDAOException;

    TreeSet<CatalogRGN> getOnlyRgnAndName() throws CatalogRGNDAOException;

    void deleteAll() throws CatalogRGNDAOException;
}
