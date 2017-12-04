package ru.inno.services;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.inno.Constants;
import ru.inno.jdbc.dao.*;
import ru.inno.jdbc.exception.*;
import ru.inno.services.interfaceService.IDownloadToDbService;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class DownloadToDbService implements IDownloadToDbService {
    private static final Logger logger = Logger.getLogger(DownloadToDbService.class);

    @Override
    public void download(String file) {
        try {

            ApplicationContext applicationcontext = new ClassPathXmlApplicationContext();
            Resource resource = applicationcontext.getResource("classpath:" + file);
            String fileNameFull = resource.getFile().getAbsolutePath();

            DbfFile dbfFile = new DbfFile(fileNameFull);
            ArrayList arrayList;
            if (file.equals(Constants.URL_FILE_BIK)) {
                arrayList = dbfFile.getDataFile(Class.forName("ru.inno.pojo.CatalogBIK"));
                CatalogBIKDAO catalogBIKDAO = new CatalogBIKDAO();
                catalogBIKDAO.addAll(arrayList);
            } else if (file.equals(Constants.URL_FILE_PZN)) {
                arrayList = dbfFile.getDataFile(Class.forName("ru.inno.pojo.CatalogPZN"));
                CatalogPZNDAO catalogPZNDAO = new CatalogPZNDAO();
                catalogPZNDAO.addAll(arrayList);
            } else if (file.equals(Constants.URL_FILE_RGN)) {
                arrayList = dbfFile.getDataFile(Class.forName("ru.inno.pojo.CatalogRGN"));
                CatalogRGNDAO catalogRGNDAO = new CatalogRGNDAO();
                catalogRGNDAO.addAll(arrayList);
            } else if (file.equals(Constants.URL_FILE_TNP)) {
                arrayList = dbfFile.getDataFile(Class.forName("ru.inno.pojo.CatalogTNP"));
                CatalogTNPDAO catalogTNPDAO = new CatalogTNPDAO();
                catalogTNPDAO.addAll(arrayList);
            } else if (file.equals(Constants.URL_FILE_UER)) {
                arrayList = dbfFile.getDataFile(Class.forName("ru.inno.pojo.CatalogUER"));
                CatalogUERDAO catalogUERDAO = new CatalogUERDAO();
                catalogUERDAO.addAll(arrayList);
            }
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
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
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}