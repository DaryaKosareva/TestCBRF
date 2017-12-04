package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.jdbc.dao.CatalogUERDAO;
import ru.inno.jdbc.exception.CatalogUERDAOException;
import ru.inno.pojo.CatalogUER;
import ru.inno.services.interfaceService.IDownloadUERService;

import java.util.TreeSet;

@Service
public class DownloadUERService implements IDownloadUERService {
    private static final Logger logger = Logger.getLogger(DownloadUERService.class);

    @Override
    public TreeSet<CatalogUER> getUER(String arg) throws CatalogUERDAOException {
        TreeSet<CatalogUER> catalog = new TreeSet<>();
        CatalogUERDAO catalogUERDAO = new CatalogUERDAO();
        switch (arg) {
            case "all":
                break;
            case "onlyUerAndName":
                catalog = catalogUERDAO.getOnlyUerAndName();
                break;
        }
        return catalog;
    }
}