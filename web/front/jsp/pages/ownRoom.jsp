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
    <meta name="keywords" content="Личный кабинет,заказ билетов,авиабилеты" >
    <title>Личный кабинет</title>
</head>
<body>
<header>
    <div class="headers">
        <div class="container">r
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
            <div class="personal_info_left">
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
        </div>
        <div class="personal_info_about_tickets">
            <div class="head">
            </div>
            <div class="tickets">

            </div>
        </div>
    </div>
</div>
</body>
</html>