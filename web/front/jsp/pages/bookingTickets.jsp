<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.09.2018
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="SHORTCUT ICON" href="front/images/icon.ico">
    <link rel="stylesheet" href="/front/css/booking_ticktets/booking_tickets.css">
    <meta charset="utf-8">
    <meta name="keywords" content="билеты на самолет, авиабилеты,заказ билетов онлайн">

    <link rel="stylesheet" href="">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Site</title>
</head>
<body>
<header>
    <div class="headers">
        <div class="container">
            <div class="logo">
                <a href="/index.jsp">LOGO</a>
            </div>
            <div class="panel">
                <ul class="top_menu">
                    <%if (session.getAttribute("user") == null) {%>
                    <li><a class="top-menu-item" href="/front/jsp/authorisation/logIn.jsp">Войти</a></li>
                    <li><a href="/front/jsp/authorisation/signUp.jsp">Регистрация</a></li>
                    <%}%>
                    <%if (session.getAttribute("user") != null) {%>
                    <li><a class="top-menu-item" href="front/jsp/pages/ownRoom.jsp">
                        ${name}</a></li>
                    <%}%>
                    <li><a href="#footers">О нас</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>
<div class="main">
    <div class="contr">
        <%if (session.getAttribute("tickets") != null) {%>
        <div class="title_booking">
            <h4 style="color: #fff3cd">Выберете нужный билет и нажмите заказать!</h4>
        </div>

        <c:forEach var="elem" items="${tickets}" varStatus="status">
            <form method="post" action="/BookingServlet" class="form_ticket">
                <div class="ticket">
                    <div class="row">
                        <div class="column">
                            <div class="column_2">
                                <div class="column_4"><p>Авиакомпания:</p></div>
                                <div class="column_4" name="airline"><p>${elem.airline}</p>
                                    <input value=${elem.airline} hidden name="airline"></div>
                            </div>
                            <div class="column_2">
                                <div class="column_4"><p>Номер рейса:</p></div>
                                <div class="column_4"><p>${elem.flightNumber}</p>
                                    <input value=${elem.flightNumber} hidden name="flightNumber">
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="column_2">
                                <div class="column_4"><p>Дата полёта:</p></div>
                                <div class="column_4-4"><p>${elem.departure_at}</p>
                                    <input value=${elem.departure_at} hidden name="departure_at"></div>
                            </div>
                            <div class="column_2">
                                <div class="column_4"><p>Дата возвращения:</p></div>
                                <div class="column_4-4"><p>${elem.return_at}</p>
                                    <input value=${elem.return_at} hidden name="return_at"></div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="column_price">
                                <div class="column_4"><p>Цена:</p></div>
                                <div class="column_4"><p>${elem.price}</p>
                                    <input value=${elem.price} hidden name="price"></div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="column_button">
                                <input type="submit" value="Заказать" class="form_submit">
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        </c:forEach>
        <%}%>
        <%if ((session.getAttribute("tickets") == null)) {%>
        <jsp:text>Билетов по данному запросу не найдено!</jsp:text>
        <%}%>
    </div>
</div>
<footer></footer>
</body>
</html>
