package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.jdbc.dao.CatalogBIKDAO;
import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.pojo.*;
import ru.inno.services.interfaceService.IDownloadBIKService;

import java.util.*;

@Service
public class DownloadBIKService implements IDownloadBIKService {
    private static final Logger logger = Logger.getLogger(DownloadBIKService.class);


    @Override
    public ArrayList<CatalogBIK> getBIK(String type, String value) throws CatalogBIKDAOException {
        CatalogBIKDAO catalogBIKDAO = new CatalogBIKDAO();
        ArrayList<CatalogBIK> catalog = catalogBIKDAO.getByValue(type, value);
        return catalog;
    }

    @Override
    public CatalogBIK getByIdBIK(String id) throws CatalogBIKDAOException {
        CatalogBIKDAO catalogBIKDAO = new CatalogBIKDAO();
        CatalogBIK catalog = catalogBIKDAO.getById(id);
        return catalog;
    }

    @Override
    public CatalogBIK getByIdPnzRegTnpUer(String id) throws CatalogBIKDAOException {
        CatalogBIKDAO catalogBIKDAO = new CatalogBIKDAO();
        CatalogBIK catalog = catalogBIKDAO.getByIdPnzRegTnpUer(id);
        return catalog;
    }
}