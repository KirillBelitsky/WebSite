<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.09.2018
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="SHORTCUT ICON" href="front/images/icon.ico">
    <meta charset="utf-8">
    <meta name="keywords" content="билеты на самолет, авиабилеты,заказ билетов онлайн">
    <link rel="stylesheet" href="front/css/site_style.css">

    <title>Site</title>
</head>
<body>
<header>
    <div class="headers">
        <div class="container">
            <div class="logo">
                <a href="/">LOGO</a>
            </div>
            <div class="panel">
                <ul class="top_menu">
                    <%if (session.getAttribute("user") == null) {%>
                    <li><a class="top-menu-item" href="front/jsp/authorisation/logIn.jsp">Войти</a></li>
                    <li><a href="front/jsp/authorisation/signUp.jsp">Регистрация</a></li>
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
    <div class="book">
        <div class="page_title">
            <div class="page_title_main">Поиск дешёвых авиабилетов</div>
            <div class="page_title_mini">Лучший способ купить авиабилеты дёшево</div>
        </div>
        <form action="/MyServlet" method="post" class="page_button">
            <div class="main_forms">
                <div class="avia_places">
                    <div class="avia_time_field">
                        <input type="text"  name="city_from" required="true" class="input_style" placeholder="Откуда">
                    </div>
                    <div class="avia_time_field">
                        <input type="text" name="city_to" class="input_style" required="true" placeholder="Куда">
                    </div>
                </div>
                <div class="avia_time">
                    <div class="avia_time_field">
                        <input type="date" name="departure_at" class="input_style_time" required="true">
                    </div>
                    <div class="avia_time_field">
                       <input class="input_style_time" type="date" name="return_at">
                    </div>
                </div>
            </div>
            <div class="button_find">
                <button class="button_find_button" type="submit">Найти билеты</button>
            </div>
        </form>
    </div>
</div>
<footer>
    <div id="footers">
        <div class="container-footer">
            <div class="row">
                <div class="footer-column">
                    <p class="footer_footer-column_logo">Air tickets booking</p>
                </div>

                <div class="footer-column">
                    <p class="footer_my_profils">Мои профили в социальных сетях:</p>
                    <p class="footer_social_icons">
                        <a href="https://vk.com/id162636479" class="fa-vk" target="_blank"><i class="fa fa-vk"
                                                                                              aria-hidden="true"></i></a>
                        <a class="fa-odnoklassniki" href="" target="_blank"><i class="fa fa-odnoklassniki"
                                                                               aria-hidden="true"></i></a>
                    <div class="button_href_vk"><a class="button_href_vk_ss" href="https://vk.com/id162636479"
                                                   target="_blank">Cвязаться Вконтакте</a></div>
                    </p>
                </div>

                <div class="footer-column">
                    <div class="footer_feadback">
                        <p class="footer_feadback_svyaz">Если хотите с нами связться,напишите нам</p>
                        <form class="footer_form" method="post" action="/FeedbackServlet">
                            <div class="footer-form-group">
                                <input type="email" class="footer_form_email" name="footer_form_email"
                                       placeholder="Email">
                            </div>
                            <textarea class="footer_form_text" name="footer_form_text" required="true" rows="5"
                                      cols="35" placeholder="Message"></textarea>
                            <input class="footer_form_submit" type="submit" name="footer_form_submit" value="Отправить">
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</footer>
<!--<script>
    const Calender = document.querySelector('.datepicker');
    M.Datepicker.init(Calender,{
        format:'dd-mm-yy',
        showClearBtn:true,

    })
</script>-->
</body>
</html>
