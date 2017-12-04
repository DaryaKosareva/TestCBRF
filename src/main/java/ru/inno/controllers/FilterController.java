package ru.inno.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.inno.jdbc.exception.CatalogBIKDAOException;
import ru.inno.jdbc.exception.CatalogPZNDAOException;
import ru.inno.services.interfaceService.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Контроллер FilterController обрабатывает запросы на фильтрацию данных из БД
 */
@Controller
public class FilterController {
    private static Logger logger = Logger.getLogger(FilterController.class);
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

    @RequestMapping(value = "/filterBIK", method = RequestMethod.POST)
    public ModelAndView postRequestFilterBIK(@RequestParam("byBik") String bik) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        try {
            modelAndView.addObject("catalogBIK", this.downloadBIKService.getBIK("byBik", bik));
            modelAndView.addObject("listPZN", this.downloadPZNService.getPZN("onlyPznAndName"));
        } catch (CatalogBIKDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        }

        logger.info("Mapping /byBik");
        return modelAndView;
    }

    @RequestMapping(value = "/filterRGN", method = RequestMethod.POST)
    public ModelAndView postRequestFilterRGN(@RequestParam("byRgn") String rgn) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        try {
            String region = new String(rgn.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            modelAndView.addObject("catalogBIK", this.downloadBIKService.getBIK("byRgn", region));
            modelAndView.addObject("listPZN", this.downloadPZNService.getPZN("onlyPznAndName"));
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogBIKDAOException e) {
            logger.error(e.getMessage());
        }
        logger.info("Mapping /byRgn");
        return modelAndView;
    }

    @RequestMapping(value = "/filterPZN", method = RequestMethod.POST)
    public ModelAndView postRequestFilterPZN(@RequestParam("byPzn") String pzn) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        try {
            modelAndView.addObject("catalogBIK", this.downloadBIKService.getBIK("byPzn", pzn));
            modelAndView.addObject("listPZN", this.downloadPZNService.getPZN("onlyPznAndName"));
        } catch (CatalogBIKDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        }
        logger.info("Mapping /byPzn");
        return modelAndView;
    }
}