package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.Constants;
import ru.inno.jdbc.dao.CatalogBIKDAO;
import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.pojo.CatalogBIK;
import ru.inno.services.interfaceService.IAddBIKService;

@Service
public class AddBIKService implements IAddBIKService {
    private static final Logger logger = Logger.getLogger(AddBIKService.class);

    @Override
    public String addBIK(CatalogBIK catalogBIK) throws CatalogBIKDAOException {
        CatalogBIKDAO catalogBIKDAO = new CatalogBIKDAO();
        Integer code = catalogBIKDAO.add(catalogBIK);
        String comment = "Комментарий: ";
        switch (code) {
            case 0:
                comment += "Запись добавлена";
                logger.info("In the BIK database added");
                break;
            case Constants.DUPLICATE_ENTRY:
                comment += "Такой БИК уже существует";
                logger.error("This BIK already exists");
                break;
            default:
                comment += "Ошибка при добавлении \'" + code + "\'";
                logger.error(" Error when adding " + code);
                break;
        }
        return comment;
    }
}