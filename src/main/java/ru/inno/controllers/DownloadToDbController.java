package ru.inno.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.inno.Constants;
import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.jdbc.exception.CatalogPZNDAOException;
import ru.inno.services.interfaceService.IDeleteFromDbService;
import ru.inno.services.interfaceService.IDownloadBIKService;
import ru.inno.services.interfaceService.IDownloadPZNService;
import ru.inno.services.interfaceService.IDownloadToDbService;

/**
 * Контроллер DownloadToDbController обрабатывает запросы на загрузку данных из DBF файлов в БД.
 */
@Controller
public class DownloadToDbController {
    private static Logger logger = Logger.getLogger(DownloadToDbController.class);
    private IDownloadToDbService downloadToDbService;
    private IDownloadBIKService downloadBIKService;
    private IDownloadPZNService downloadPZNService;
    private IDeleteFromDbService deleteFromDbService;

    @Autowired(required = true)
    @Qualifier(value = "deleteFromDbService")
    public void setDeleteFromDbService(IDeleteFromDbService ds) {
        this.deleteFromDbService = ds;
    }

    @Autowired(required = true)
    @Qualifier(value = "downloadToDbService")
    public void setDownloadToDbService(IDownloadToDbService ds) {
        this.downloadToDbService = ds;
    }


    @Autowired(required = true)
    @Qualifier(value = "downloadPZNService")
    public void setDownloadPZNService(IDownloadPZNService ds) {
        this.downloadPZNService = ds;
    }

    @Autowired(required = true)
    @Qualifier(value = "downloadBIKService")
    public void setDownloadBIKService(IDownloadBIKService ds) {
        this.downloadBIKService = ds;
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ModelAndView getRequestDownload() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        try {
            deleteFromDbService.delete("bnkseek");
            deleteFromDbService.delete("pzn");
            deleteFromDbService.delete("rgn");
            deleteFromDbService.delete("tnp");
            deleteFromDbService.delete("uer");
            downloadToDbService.download(Constants.URL_FILE_BIK);
            downloadToDbService.download(Constants.URL_FILE_PZN);
            downloadToDbService.download(Constants.URL_FILE_RGN);
            downloadToDbService.download(Constants.URL_FILE_TNP);
            downloadToDbService.download(Constants.URL_FILE_UER);
            modelAndView.addObject("comment", "Комментарий: База загружена");
            modelAndView.addObject("catalogBIK", this.downloadBIKService.getBIK("all", ""));
            modelAndView.addObject("listPZN", this.downloadPZNService.getPZN("onlyPznAndName"));

        } catch (CatalogBIKDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        }

        logger.info("Mapping /download");
        return modelAndView;
    }
}