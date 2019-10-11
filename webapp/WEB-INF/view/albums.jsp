<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Альбомы</title>
    <style type="text/css">
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
        .table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            border-collapse: collapse;
            text-align: center;
        }
        .table th, td:first-child {
            background: #AFCDE7;
            color: white;
            padding: 10px 20px;
        }
        .table th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }
        .table td {
            background: #D8E6F3;
        }
        .table th:first-child, td:first-child {
            text-align: left;
        }
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 5px 5px;
            overflow: hidden;
            word-break: normal;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            color: #333;
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>

<a href="/audio-0.0.1-SNAPSHOT/">Назад</a>

<br/>
<br/>

<h2>Список альбомов</h2>

<c:if test="${!empty albumList}">
    <table class="table">
        <tr>
            <th hidden="true" width="40">ID</th>
            <th width="120">Название</th>
            <th width="120">Количество песен</th>
            <th width="120">Год</th>
            <th width="60"></th>
            <th width="60"></th>
        </tr>
        <c:forEach items="${albumList}" var="album">
            <tr>
                <td hidden="true"><c:out value="${album.idAlbum}"/></td>
                <td><c:out value="${album.nameAlbum}"/></td>
                <td><c:out value="${album.songsCountAlbum}"/></td>
                <td><c:out value="${album.yearAlbum}"/></td>
                <td><a href="<c:url value='/albums/edit/${album.idAlbum}'/>">Редактировать</a></td>
                <td><a href="<c:url value='/albums/delete/${album.idAlbum}'/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h2>Добавить альбом</h2>

<c:url var="addAction" value="/albums/add"/>

<form:form action="${addAction}" commandName="album">
    <table class="tg">
        <c:if test="${!empty album.idAlbum}">
            <tr>
                <td>
                    <form:label path="idAlbum" hidden="true">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idAlbum" readonly="true" disabled="true" hidden="true"/>
                    <form:hidden path="idAlbum"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameAlbum">
                    <spring:message text="Название"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameAlbum" type="text"/>
            </td>
            <td>
                <form:errors path="nameAlbum" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="songsCountAlbum">
                    <spring:message text="Количество песен"/>
                </form:label>
            </td>
            <td>
                <form:input path="songsCountAlbum" type="number"/>
            </td>
            <td>
                <form:errors path="songsCountAlbum" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="yearAlbum">
                    <spring:message text="Год"/>
                </form:label>
            </td>
            <td>
                <form:input path="yearAlbum" type="number"/>
            </td>
            <td>
                <form:errors path="yearAlbum" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <c:if test="${!empty album.nameAlbum}">
                <td>
                    <input type="submit"
                           value="<spring:message text="Редактировать альбом"/>"/>
                </td>
                <td>
                    <form action="/albums">
                        <input type="submit" value="<spring:message text="Назад"/>"
                               name="Submit" id="frm1_submit"/>
                    </form>
                </td>
            </c:if>
            <c:if test="${empty album.nameAlbum}">
                <td colspan="2">
                    <input type="submit"
                           value="<spring:message text="Добавить альбом"/>"/>
                </td>
            </c:if>
        </tr>
    </table>
</form:form>
</body>
</html>