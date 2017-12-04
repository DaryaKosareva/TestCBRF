package ru.inno.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.jdbc.exception.CatalogPZNDAOException;
import ru.inno.services.interfaceService.*;

/**
 * Контроллер DownloadController обрабатывает запросы на вывод всех БИК из БД в браузер
 */
@Controller
public class DownloadController {
    private static Logger logger = Logger.getLogger(DownloadController.class);
    private IDownloadBIKService downloadBIKService;
    private IDownloadPZNService downloadPZNService;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getRequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        try {
            modelAndView.addObject("catalogBIK", this.downloadBIKService.getBIK("all", ""));
            modelAndView.addObject("listPZN", this.downloadPZNService.getPZN("onlyPznAndName"));

        } catch (CatalogBIKDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        }

        logger.info("Mapping /");
        return modelAndView;
    }
}