package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.jdbc.dao.CatalogBIKDAO;
import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.services.interfaceService.IDeleteBIKService;

@Service
public class DeleteBIKService implements IDeleteBIKService {
    private static final Logger logger = Logger.getLogger(DeleteBIKService.class);

    @Override
    public void deleteBIK(Integer id) throws CatalogBIKDAOException {
        CatalogBIKDAO catalogBIKDAO = new CatalogBIKDAO();
        catalogBIKDAO.deleteById(id);
    }
}