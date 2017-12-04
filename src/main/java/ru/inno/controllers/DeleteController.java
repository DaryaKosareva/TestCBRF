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
 * Контроллер DeleteController обрабатывает запросы на удаление БИК в БД.
 */
@Controller
public class DeleteController {
    private static Logger logger = Logger.getLogger(DeleteController.class);
    private IDownloadBIKService downloadBIKService;
    private IDownloadPZNService downloadPZNService;
    private IDeleteBIKService deleteBIKService;

    @Autowired(required = true)
    @Qualifier(value = "deleteBIKService")
    public void setDeleteBIKService(IDeleteBIKService ds) {
        this.deleteBIKService = ds;
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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView getRequestDelete(@RequestParam("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        try {
            this.deleteBIKService.deleteBIK(Integer.parseInt(id));
            modelAndView.addObject("catalogBIK", this.downloadBIKService.getBIK("all", ""));
            modelAndView.addObject("listPZN", this.downloadPZNService.getPZN("onlyPznAndName"));

        } catch (CatalogBIKDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        }

        logger.info("Mapping /delete");
        return modelAndView;
    }
}