package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.jdbc.dao.*;
import ru.inno.jdbc.exception.*;
import ru.inno.services.interfaceService.IDeleteFromDbService;

@Service
public class DeleteFromDbService implements IDeleteFromDbService {
    private static final Logger logger = Logger.getLogger(DeleteFromDbService.class);

    @Override
    public void delete(String table) {
        try {

            if (table.equals("bnkseek")) {
                CatalogBIKDAO catalogBIKDAO = new CatalogBIKDAO();
                catalogBIKDAO.deleteAll();
            } else if (table.equals("pzn")) {
                CatalogPZNDAO catalogPZNDAO = new CatalogPZNDAO();
                catalogPZNDAO.deleteAll();
            } else if (table.equals("rgn")) {
                CatalogRGNDAO catalogRGNDAO = new CatalogRGNDAO();
                catalogRGNDAO.deleteAll();
            } else if (table.equals("tnp")) {
                CatalogTNPDAO catalogTNPDAO = new CatalogTNPDAO();
                catalogTNPDAO.deleteAll();
            } else if (table.equals("uer")) {
                CatalogUERDAO catalogUERDAO = new CatalogUERDAO();
                catalogUERDAO.deleteAll();
            }
        } catch (CatalogBIKDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogTNPDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogUERDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogRGNDAOException e) {
            logger.error(e.getMessage());
        }
    }
}