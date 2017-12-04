package ru.inno.services;

import org.apache.log4j.Logger;
import org.jamel.dbf.DbfReader;
import org.jamel.dbf.exception.*;
import org.jamel.dbf.structure.DbfRow;
import org.springframework.stereotype.Service;
import ru.inno.pojo.*;
import ru.inno.services.interfaceService.IDbfFile;

import java.beans.*;
import java.io.*;
import java.lang.reflect.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Класс для работы с DBF файлами
 */
@Service
public class DbfFile implements IDbfFile {
    private static Logger logger = Logger.getLogger(DbfFile.class);
    private ArrayList dataFile;
    private String nameFile;

    public DbfFile() {
    }

    public DbfFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /**
     * Получение данных из DBF файла.
     * @param myClass - класс, который описывает соответствующий файл (CatalogBIK, CatalogPZN,
     *                CatalogRGN, CatalogTNP,CatalogUER)
     * @return - возвращает строки из файла в ввиде ArrayList<myClass>
     */
    @Override
    public ArrayList getDataFile(Class myClass) {
        dataFile = new ArrayList();
        try (DbfReader reader = new DbfReader(new File(nameFile), Charset.forName("Cp866"))) {
            DbfRow dbfRow;
            while ((dbfRow = reader.nextRow()) != null) {
                Field[] fields = myClass.getDeclaredFields();
                Object o = myClass.newInstance();
                for (Field field : fields) {
                    if (!field.getName().equals("id")) {
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), myClass);
                        Method setter = propertyDescriptor.getWriteMethod();
                        String fieldNAME = field.getName().toUpperCase();
                        if (field.getType().getSimpleName().equals("String")) {
                            setter.invoke(o, dbfRow.getString(fieldNAME) != null ? dbfRow.getString(fieldNAME) : "");
                        } else {
                            setter.invoke(o, dbfRow.getDate(fieldNAME) != null ? dbfRow.getDate(fieldNAME) : "");
                        }
                        Method getter = propertyDescriptor.getReadMethod();
                        Object f = getter.invoke(o);
                    }
                }
                if (o instanceof CatalogBIK) {
                    CatalogBIK catalog = (CatalogBIK) o;
                    dataFile.add(catalog);
                } else if (o instanceof CatalogPZN) {
                    CatalogPZN catalog = (CatalogPZN) o;
                    dataFile.add(catalog);
                } else if (o instanceof CatalogRGN) {
                    CatalogRGN catalog = (CatalogRGN) o;
                    dataFile.add(catalog);
                } else if (o instanceof CatalogTNP) {
                    CatalogTNP catalog = (CatalogTNP) o;
                    dataFile.add(catalog);
                } else if (o instanceof CatalogUER) {
                    CatalogUER catalog = (CatalogUER) o;
                    dataFile.add(catalog);
                }
            }
        } catch (DbfException e) {
            logger.error(e.getMessage());
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        } catch (IntrospectionException e) {
            logger.error(e.getMessage());
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage());
        } catch (InstantiationException e) {
            logger.error(e.getMessage());
        }
        return dataFile;
    }

    @Override
    public void setDataFile(ArrayList dataFile) {
        this.dataFile = dataFile;
    }

    @Override
    public String getNameFile() {
        return nameFile;
    }

    @Override
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
}