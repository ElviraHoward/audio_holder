<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Песни</title>
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

<h2>Список песен</h2>

<c:if test="${!empty songList}">
    <table class="table">
        <tr>
            <th width="40" hidden="true">ID</th>
            <th width="120">Название</th>
            <th width="120">Жанр</th>
            <th width="120">Альбом</th>
            <th width="120">Исполнитель</th>
            <th width="60"></th>
            <th width="60"></th>
        </tr>
        <c:forEach items="${songList}" var="song">
            <tr>
                <td hidden="true"><c:out value="${song.idSong}"/></td>
                <td><c:out value="${song.nameSong}"/></td>
                <td><c:out value="${song.genreSong}"/></td>
                <td><c:out value="${song.songByAlbum}"/></td>
                <td><c:out value="${song.songBySinger}"/></td>
                <td><a href="<c:url value='/songs/edit/${song.idSong}'/>">Редактировать</a></td>
                <td><a href="<c:url value='/songs/delete/${song.idSong}'/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h2>Добавить песню</h2>

<c:url var="addAction" value="/songs/add"/>

<form:form action="${addAction}" commandName="song">
    <table class="tg">
        <c:if test="${!empty song.idSong}">
            <tr>
                <td>
                    <form:label path="idSong" hidden="true">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idSong" readonly="true" disabled="true" hidden="true"/>
                    <form:hidden path="idSong"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameSong">
                    <spring:message text="Название"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameSong" type="text"/>
            </td>
            <td>
                <form:errors path="nameSong" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="genreSong">
                    <spring:message text="Жанр"/>
                </form:label>
            </td>
            <td>
                <form:input path="genreSong" type="text"/>
            </td>
            <td>
                <form:errors path="genreSong" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="songByAlbum">
                    <spring:message text="Альбом"/>
                </form:label>
            </td>
            <td>
                <sf:select path="songByAlbum" multiple="true">
                    <c:forEach items="${albumList}" var="album">
                        <sf:option value="${album.idAlbum}">${album.nameAlbum}</sf:option>
                    </c:forEach>
                </sf:select>
            </td>
            <td>
                <form:errors path="songByAlbum" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="songBySinger">
                    <spring:message text="Исполнитель"/>
                </form:label>
            </td>
            <td>
                <sf:select path="songBySinger" multiple="true">
                    <c:forEach items="${singerList}" var="singer">
                        <sf:option value="${singer.idSinger}">${singer.nameSinger}</sf:option>
                    </c:forEach>
                </sf:select>
            </td>
            <td>
                <form:errors path="songBySinger" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <c:if test="${!empty song.nameSong}">
                <td>
                    <input type="submit"
                           value="<spring:message text="Редактировать песню"/>"/>
                </td>
                <td>
                    <form action="/songs">
                        <input type="submit" value="<spring:message text="Назад"/>"
                               name="Submit" id="frm1_submit"/>
                    </form>
                </td>
            </c:if>
            <c:if test="${empty song.nameSong}">
                <td colspan="2">
                    <input type="submit"
                           value="<spring:message text="Добавить песню"/>"/>
                </td>
            </c:if>
        </tr>
    </table>
</form:form>
</body>
</html>