package ru.inno.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.inno.Parse;
import ru.inno.jdbc.exception.*;
import ru.inno.pojo.CatalogBIK;
import ru.inno.services.interfaceService.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * Контроллер AddController обрабатывает запросы на добавление нового БИК в БД.
 */
@Controller
public class AddController {
    private static Logger logger = Logger.getLogger(AddController.class);
    private IDownloadBIKService downloadBIKService;
    private IDownloadPZNService downloadPZNService;
    private IDownloadTNPService downloadTNPService;
    private IDownloadUERService downloadUERService;
    private IDownloadRGNService downloadRGNService;
    private IAddBIKService addBIKService;

    @Autowired(required = true)
    @Qualifier(value = "addBIKService")
    public void setAddBIKService(IAddBIKService ds) {
        this.addBIKService = ds;
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

    @Autowired(required = true)
    @Qualifier(value = "downloadTNPService")
    public void setDownloadTNPService(IDownloadTNPService ds) {
        this.downloadTNPService = ds;
    }

    @Autowired(required = true)
    @Qualifier(value = "downloadRGNService")
    public void setDownloadRGNService(IDownloadRGNService ds) {
        this.downloadRGNService = ds;
    }

    @Autowired(required = true)
    @Qualifier(value = "downloadUERService")
    public void setDownloadUERService(IDownloadUERService ds) {
        this.downloadUERService = ds;
    }

    @RequestMapping(value = "/formAdd", method = RequestMethod.POST)
    public ModelAndView getRequestFormAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        try {
            modelAndView.addObject("listPZN", this.downloadPZNService.getPZN("onlyPznAndName"));
            modelAndView.addObject("listTNP", this.downloadTNPService.getTNP("onlyTnpAndName"));
            modelAndView.addObject("listUER", this.downloadUERService.getUER("onlyUerAndName"));
            modelAndView.addObject("listRGN", this.downloadRGNService.getRGN("onlyRgnAndName"));
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogUERDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogRGNDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogTNPDAOException e) {
            logger.error(e.getMessage());
        }

        logger.info("Mapping /formAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView postRequestAdd(@RequestParam("real") String real2,
                                       @RequestParam("pzn") String pzn,
                                       @RequestParam("uer") String uer,
                                       @RequestParam("rgn") String rgn,
                                       @RequestParam("ind") String ind2,
                                       @RequestParam("tnp") String tnp,
                                       @RequestParam("nnp") String nnp2,
                                       @RequestParam("adr") String adr2,
                                       @RequestParam("rkc") String rkc2,
                                       @RequestParam("namep") String namep2,
                                       @RequestParam("newnum") String newnum2,
                                       @RequestParam("telef") String telef2,
                                       @RequestParam("regn") String regn2,
                                       @RequestParam("okpo") String okpo2,
                                       @RequestParam("dt_izm") String dt_izm,
                                       @RequestParam("ksnp") String ksnp2,
                                       @RequestParam("date_in") String date_in,
                                       @RequestParam("date_ch") String date_ch) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            String real = new String(real2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String newnum = new String(newnum2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String ind = new String(ind2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String rkc = new String(rkc2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String telef = new String(telef2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String okpo = new String(okpo2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String ksnp = new String(ksnp2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String nnp = new String(nnp2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String adr = new String(adr2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String namep = new String(namep2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            String regn = new String(regn2.getBytes("ISO-8859-1"), Charset.forName("Cp1251"));
            Date dt_izm_conv = new Date(Parse.stringParseInMilliseconds(dt_izm, "yyyy-MM-dd"));
            Date date_in_conv = new Date(Parse.stringParseInMilliseconds(date_in, "yyyy-MM-dd"));
            Date date_ch_conv = null;
            if (!date_ch.equals("")) {
                date_ch_conv = new Date(Parse.stringParseInMilliseconds(date_ch, "yyyy-MM-dd"));
            }

            modelAndView.setViewName("index");

            CatalogBIK catalogBIK = new CatalogBIK(real, pzn, uer, rgn, ind, tnp, nnp, adr, rkc, namep, newnum, telef,
                    regn, okpo, dt_izm_conv, ksnp, date_in_conv, date_ch_conv);
            String gg = this.addBIKService.addBIK(catalogBIK);

            modelAndView.addObject("comment", gg);
            modelAndView.addObject("catalogBIK", this.downloadBIKService.getBIK("all", ""));
            modelAndView.addObject("listPZN", this.downloadPZNService.getPZN("onlyPznAndName"));
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        } catch (CatalogPZNDAOException e) {
            logger.error(e.getMessage());
        } catch (CatalogBIKDAOException e) {
            logger.error(e.getMessage());
        }
        logger.info("Mapping /add");
        return modelAndView;
    }
}