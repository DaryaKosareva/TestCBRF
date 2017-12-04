package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.jdbc.dao.CatalogRGNDAO;
import ru.inno.jdbc.exception.CatalogRGNDAOException;
import ru.inno.pojo.CatalogRGN;
import ru.inno.services.interfaceService.IDownloadRGNService;

import java.util.TreeSet;

@Service
public class DownloadRGNService implements IDownloadRGNService {
    private static final Logger logger = Logger.getLogger(DownloadRGNService.class);

    @Override
    public TreeSet<CatalogRGN> getRGN(String arg) throws CatalogRGNDAOException {
        TreeSet<CatalogRGN> catalog = new TreeSet<>();
        CatalogRGNDAO catalogRGNDAO = new CatalogRGNDAO();
        switch (arg) {
            case "all":
                break;
            case "onlyRgnAndName":
                catalog = catalogRGNDAO.getOnlyRgnAndName();
                break;
        }
        return catalog;
    }
}