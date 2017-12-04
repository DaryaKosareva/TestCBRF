package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.jdbc.dao.CatalogPZNDAO;
import ru.inno.jdbc.exception.CatalogPZNDAOException;
import ru.inno.pojo.CatalogPZN;
import ru.inno.services.interfaceService.IDownloadPZNService;

import java.util.TreeSet;

@Service
public class DownloadPZNService implements IDownloadPZNService {
    private static final Logger logger = Logger.getLogger(DownloadPZNService.class);

    @Override
    public TreeSet<CatalogPZN> getPZN(String arg) throws CatalogPZNDAOException {
        TreeSet<CatalogPZN> catalog = new TreeSet<>();
        CatalogPZNDAO catalogPZNDAO = new CatalogPZNDAO();
        switch (arg) {
            case "all":
                break;
            case "onlyPznAndName":
                catalog = catalogPZNDAO.getOnlyPznAndName();
                break;
        }
        return catalog;
    }
}