package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.inno.jdbc.dao.CatalogBIKDAO;
import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.pojo.CatalogBIK;
import ru.inno.services.interfaceService.IEditBIKService;

@Service
public class EditBIKService implements IEditBIKService {
    private static final Logger logger = Logger.getLogger(EditBIKService.class);

    @Override
    public String editBIK(CatalogBIK catalogBIK, Integer id) throws CatalogBIKDAOException {
        CatalogBIKDAO catalogBIKDAO = new CatalogBIKDAO();
        Integer code = null;
        code = catalogBIKDAO.update(catalogBIK, id);
        String comment = "Комментарий: ";
        if (code == 0) {
            comment += "Запись обновлена";
        } else {
            comment += "Ошибка при редактировании " + code;
        }
        return comment;
    }
}