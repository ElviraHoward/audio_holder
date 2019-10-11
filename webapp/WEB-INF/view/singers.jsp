<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Исполнители</title>
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

<h2>Список исполнителей</h2>

<c:if test="${!empty singerList}">
    <table class="table">
        <tr>
            <th hidden="true" width="40">ID</th>
            <th width="120">Имя</th>
            <th width="120">Возраст</th>
            <th width="60"></th>
            <th width="60"></th>
        </tr>
        <c:forEach items="${singerList}" var="singer">
            <tr>
                <td hidden="true"><c:out value="${singer.idSinger}"/></td>
                <td><c:out value="${singer.nameSinger}"/></td>
                <td><c:out value="${singer.ageSinger}"/></td>
                <td><a href="<c:url value='/singers/edit/${singer.idSinger}'/>">Редактировать</a></td>
                <td><a href="<c:url value='/singers/delete/${singer.idSinger}'/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h2>Добавить исполнителя</h2>

<c:url var="addAction" value="/singers/add"/>

<form:form action="${addAction}" commandName="singer">
    <table class="tg">
        <c:if test="${!empty singer.idSinger}">
            <tr>
                <td>
                    <form:label path="idSinger" hidden="true">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idSinger" readonly="true" disabled="true" hidden="true"/>
                    <form:hidden path="idSinger"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameSinger">
                    <spring:message text="Имя"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameSinger" type="text"/>
            </td>
            <td>
                <form:errors path="nameSinger" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ageSinger">
                    <spring:message text="Возраст"/>
                </form:label>
            </td>
            <td>
                <form:input path="ageSinger" type="number"/>
            </td>
            <td>
                <form:errors path="ageSinger" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <c:if test="${!empty singer.nameSinger}">
                <td>
                    <input type="submit"
                           value="<spring:message text="Редактировать исполнителя"/>"/>
                </td>
                <td>
                    <form action="/singers">
                        <input type="submit" value="<spring:message text="Назад"/>"
                               name="Submit" id="frm1_submit"/>
                    </form>
                </td>
            </c:if>
            <c:if test="${empty singer.nameSinger}">
                <td colspan="2">
                    <input type="submit"
                           value="<spring:message text="Добавить исполнителя"/>"/>
                </td>
            </c:if>
        </tr>
    </table>
</form:form>
</body>
</html>