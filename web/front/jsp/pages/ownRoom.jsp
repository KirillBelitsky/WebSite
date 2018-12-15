<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 28.10.18
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/front/css/private_office/private_office.css">
    <meta charset="utf-8">
    <meta name="keywords" content="Личный кабинет,заказ билетов,авиабилеты">
    <title>Личный кабинет</title>
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
                    <li><a href="/index.jsp">Выйти</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>
<div class="content">
    <h1 class="header_content">Личный кабинет</h1>
    <div class="content_inside">
        <div class="personal_info">
            <table class="personal_info_list">
                <tbody>
                <tr class="personal_info_list_row">
                    <th class="personal-info-list_cell_personal-info-list_cell__key">Имя</th>
                    <th class="personal-info-list_cell_personal-info-list_cell__value">${name}</th>
                </tr>
                <tr class="personal_info_list_row">
                    <th class="personal-info-list_cell_personal-info-list_cell__key">Место жительство</th>
                    <th class="personal-info-list_cell_personal-info-list_cell__value">${country}</th>
                </tr>
                <tr class="personal_info_list_row">
                    <th class="personal-info-list_cell_personal-info-list_cell__key">Email</th>
                    <th class="personal-info-list_cell_personal-info-list_cell__value">${email}</th>
                </tr>
                <tr class="personal_info_list_row">
                    <th class="personal-info-list_cell_personal-info-list_cell__key">Номер телефона</th>
                    <th class="personal-info-list_cell_personal-info-list_cell__value">${phone}</th>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="personal_info_about_tickets">
            <div class="head">
                <h5>Мои билеты</h5>
            </div>
            <div class="tickets">
                <c:forEach var="elem" items="${tickets}">
                    <form>
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
            </div>
        </div>
    </div>
</div>
</body>
</html>