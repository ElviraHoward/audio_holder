<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Аудиотека</title>
  <style>
    body {
      background: url(images/default.jpg) no-repeat;
      -moz-background-size: 100%; /* Firefox 3.6+ */
      -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
      -o-background-size: 100%; /* Opera 9.6+ */
      background-size: 100%; /* Современные браузеры */
    }
    h1{
      margin-top: 15%;
      margin-left: 40%;
      color: white;
      font-family: SansSerif, serif;
    }
    div {
      display: flex;
      margin-left: 25%;
    }
    a {
      font-size: x-large;
      color: white;
      margin: 10px;
      font-family: SansSerif, serif;
    }
  </style>
</head>
<body>
<h1>Главное меню</h1>
<div>
  <br/>
  <a href="<c:url value="/songs"/>">Список песен</a>
  <br/>
  <br/>
  <a href="<c:url value="/albums"/>">Список альбомов</a>
  <br/>
  <br/>
  <a href="<c:url value="/singers"/>">Список исполнителей</a>
  <br/>
</div>
</body>
</html>