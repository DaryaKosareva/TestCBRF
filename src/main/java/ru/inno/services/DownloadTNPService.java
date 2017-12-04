package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.jdbc.dao.CatalogTNPDAO;
import ru.inno.jdbc.exception.CatalogTNPDAOException;
import ru.inno.pojo.CatalogTNP;
import ru.inno.services.interfaceService.IDownloadTNPService;

import java.util.TreeSet;

@Service
public class DownloadTNPService implements IDownloadTNPService {
    private static final Logger logger = Logger.getLogger(DownloadTNPService.class);

    @Override
    public TreeSet<CatalogTNP> getTNP(String arg) throws CatalogTNPDAOException {
        TreeSet<CatalogTNP> catalog = new TreeSet<>();
        CatalogTNPDAO catalogTNPDAO = new CatalogTNPDAO();
        switch (arg) {
            case "all":
                break;
            case "onlyTnpAndName":
                catalog = catalogTNPDAO.getOnlyTnpAndName();
                break;
        }
        return catalog;
    }
}