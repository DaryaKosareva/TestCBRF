<%@ page contentType="text/html;charset=cp1251" pageEncoding="cp1251" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">

<html>
<head>
    <title>Работа со Справочником БИК Банка России</title>
    <style>
        table[name="table"] {
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

        select {
            width: 40%;
            margin-bottom: 10px;
        }

        div[id="comment"] {
            color: red;
        }

        label[name="form"] {
            width: 30px;
        }
    </style>
</head>
<body>
<form id="formDownload" method="post" action="/testCBRF/download">
    <input type="submit" value="загрузить"/>
</form>
<br/>

<form id="formFilterBik" method="post" action="/testCBRF/filterBIK">
    БИК <input type="text" name="byBik" maxlength="9" id="byBik" required/>
    <input type="submit" value="фильтр"/>
</form>

<form id="formFilterRgn" method="post" action="/testCBRF/filterRGN">
    Регион <input type="text" name="byRgn" maxlength="30" id="byRgn" required/>
    <input type="submit" value="фильтр"/>
</form>

<form id="formFilterPzn" method="post" action="/testCBRF/filterPZN">
    Тип
    <select id="byPzn" name="byPzn">
        <option value="" selected>Выберите</option>
        <c:forEach items="${listPZN}" var="pzns">
            <option value="${pzns.pzn}">
                <c:out value="${pzns.name}"/>
            </option>
        </c:forEach>
    </select>
    <input type="submit" value="фильтр"/>
</form>

<form id="myForm" method="post" action="/testCBRF/formAdd">
    <input type="submit" value="добавить новый БИК"/>
</form>
<br/>
<div id="comment">${comment}</div>
<br/>
<table name="table" cellspacing="0">
    <tr>
        <td><b></b></td>
        <td><b></b></td>
        <td><b>REAL</b></td>
        <td><b>PZN</b></td>
        <td><b>UER</b></td>
        <td><b>RGN</b></td>
        <td><b>IND</b></td>
        <td><b>TNP</b></td>
        <td><b>NNP</b></td>
        <td><b>ADR</b></td>
        <td><b>RKC</b></td>
        <td><b>NAMEP</b></td>
        <td><b>NEWNUM</b></td>
        <td><b>TELEF</b></td>
        <td><b>REGN</b></td>
        <td><b>OKPO</b></td>
        <td><b>DT_IZM</b></td>
        <td><b>KSNP</b></td>
        <td><b>DATE_IN</b></td>
        <td><b>DATE_CH</b></td>

    </tr>
    <c:forEach items="${catalogBIK}" var="catalog">
        <tr>
            <td>
                <form id="formDelete" method="post" action="/testCBRF/delete">
                    <input type="hidden" name="id" value="${catalog.id}"/>
                    <input type="submit" value="Удалить"/>
                </form>
            </td>
            <td>
                <form id="formEdit" method="post" action="/testCBRF/formEdit">
                    <input type="hidden" name="id" value="${catalog.id}"/>
                    <input type="submit" value="Редактировать"/>
                </form>
            </td>
            <td>
                <c:out value="${catalog.real}"/>
            </td>
            <td>
                <c:out value="${catalog.pzn}"/>
            </td>
            <td>
                <c:out value="${catalog.uer}"/>
            </td>
            <td>
                <c:out value="${catalog.rgn}"/>
            </td>
            <td>
                <c:out value="${catalog.ind}"/>
            </td>
            <td>
                <c:out value="${catalog.tnp}"/>
            </td>
            <td>
                <c:out value="${catalog.nnp}"/>
            </td>
            <td>
                <c:out value="${catalog.adr}"/>
            </td>
            <td>
                <c:out value="${catalog.rkc}"/>
            </td>
            <td>
                <c:out value="${catalog.namep}"/>
            </td>
            <td>
                <c:out value="${catalog.newnum}"/>
            </td>
            <td>
                <c:out value="${catalog.telef}"/>
            </td>
            <td>
                <c:out value="${catalog.regn}"/>
            </td>
            <td>
                <c:out value="${catalog.okpo}"/>
            </td>
            <td>
                <c:out value="${catalog.dt_izm}"/>
            </td>
            <td>
                <c:out value="${catalog.ksnp}"/>
            </td>
            <td>
                <c:out value="${catalog.date_in}"/>
            </td>
            <td>
                <c:out value="${catalog.date_ch}"/>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>