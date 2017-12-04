<%--
  Created by IntelliJ IDEA.
  User: Danya
  Date: 27.11.2017
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>

<meta http-equiv="content-type" content="text/html; charset=cp1251">

<%@ page contentType="text/html;charset=Cp1251" pageEncoding="Cp1251" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавить новый БИК</title>
    <style>
        table {
            border: solid 1px #555555;
        }

        td, th {
            border: solid 1px #555555;
            font-size: 10px;
            text-transform: capitalize;
            font-family: Verdana;
        }

        input[type="text"] {
            width: 40%;
            margin-bottom: 10px;
        }

        input[type="date"] {
            width: 40%;
            margin-bottom: 10px;
        }

        select {
            width: 40%;
            margin-bottom: 10px;
        }
    </style>

</head>
<body>

<form id="formAdd" method="post" action="/testCBRF/add">
    <br/> <input type="text" name="real" id="real" maxlength="4" value=""/>
    REAL (Код контроля допустимости проведения расчетных операций)
    <br/>
    <select id="pzn" name="pzn">
        <option value="" selected>Выберите</option>
        <c:forEach items="${listPZN}" var="pzns">
            <option value="${pzns.pzn}">
                <c:out value="${pzns.name}"/>
            </option>
        </c:forEach>
    </select> PZN (Тип участника раcчетов)
    <br/>
    <select id="uer" name="uer" required>
        <option value="" selected>Выберите</option>
        <c:forEach items="${listUER}" var="uers">
            <option value="${uers.uer}">
                <c:out value="${uers.uername}"/>
            </option>
        </c:forEach>
    </select> UER (Тип участника/пользователя системы электронных расчетов)
    <br/>
    <select id="rgn" name="rgn" required>
        <option value="" selected>Выберите</option>
        <c:forEach items="${listRGN}" var="rgns">
            <option value="${rgns.rgn}">
                <c:out value="${rgns.name}"/>
            </option>
        </c:forEach>
    </select> RGN (Территория Российской
    Федерации)
    <br/> <input type="text" name="ind" id="ind" maxlength="6" value=""/> IND (Индекс)
    <br/>
    <select id="tnp" name="tnp">
        <option value="" selected>Выберите</option>
        <c:forEach items="${listTNP}" var="tnps">
            <option value="${tnps.tnp}">
                <c:out value="${tnps.fullname}"/>
            </option>
        </c:forEach>
    </select> TNP (Тип населенного пункта)
    <br/> <input type="text" name="nnp" id="nnp" maxlength="25" value=""/> NNP (Населенный пункт)
    <br/> <input type="text" name="adr" id="adr" maxlength="30" value=""/> ADR (Адрес)
    <br/> <input type="text" name="rkc" id="rkc" maxlength="9" value=""/> RKC (БИК РКЦ)
    <br/> <input type="text" name="namep" id="namep" maxlength="45" value="" required/> NAMEP (Наименование участника
    расчетов)
    <br/> <input type="text" name="newnum" id="newnum" maxlength="9" value="" required/> NEWNUM (БИК)
    <br/> <input type="text" name="telef" id="telef" maxlength="25" value=""/> TELEF (Телефон)
    <br/> <input type="text" name="regn" id="regn" maxlength="9" value=""/> REGN (Регистрационный номер)
    <br/> <input type="text" name="okpo" id="okpo" maxlength="8" value=""/> OKPO (Код ОКПО)
    <br/> <input type="date" name="dt_izm" id="dt_izm" value="" required/> DT_IZM (Дата последнего изменения
    записи)
    <br/> <input type="text" name="ksnp" id="ksnp" maxlength="20" value=""/> KSNP (Номер счета)
    <br/> <input type="date" name="date_in" id="date_in" value="" required/>
    DATE_IN (Дата включения информации об участнике расчетов в ЭБД)
    <br/> <input type="date" name="date_ch" id="date_ch" value=""/> DATE_CH (Дата контроля)

    <br/>
    <input type="submit" value="добавить"/>
</form>
<br/>

</body>
</html>
