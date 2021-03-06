<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 11.10.18
  Time: 21.52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="/front/css/signUp/sign_up.css">
    <meta name="keywords" content="билеты на самолет, авиабилеты,регистрация">
</head>
<body>
<header>
    <div class="headers">
        <div class="container">
            <div class="logo">
                <a href="/">LOGO</a>
            </div>
            <div id="window">

            </div>
            <div class="panel">
                <ul class="top_menu">
                    <li><a class="top-menu-item" href="/front/jsp/authorisation/logIn.jsp">Войти</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>
<div class="containers">
    <div class="containers_content">
        <h1>Регистрация</h1>
        <div class="first_text">Обращаем Ваше внимание на необходимость заполнения регистрационной анкеты в точном
            соответствии с паспортными данными. При изменении паспортных данных просим Вас известить об этом
            незамедлительно.
        </div>
        <div id="registration">
            <form method="post" action="/SignUpServlet" class="registration_verical">
                <div class="panel_form_group">
                    <div class="panel_form_group_data">
                        <div class="data"><strong>Личные данные</strong></div>
                    </div>
                    <div class="panel_form_group_data">
                        <div class="col-mb-12">
                            <input type="radio" name="sex" id="Gender_M" value="M">
                            <label for="Gender_M">Мужской</label>
                            <input type="radio" name="sex" id="Gender_W" value="W">
                            <label for="Gender_W">Женский</label>
                        </div>
                    </div>
                    <div class="col_group">
                        <div class="col_group-mb-12">
                            <div class="wrapper">
                                <input type="text" class="input_data" name="secondName" autocomplete="off"
                                       required="true" placeholder="Фамилия" style="color: #555">
                            </div>
                            <p class="text_details">Латинскими буквами,как в паспорте</p>
                        </div>
                        <div class="col_group-mb-12">
                            <div class="wrapper">
                                <input type="text" class="input_data" name="firstName" autocomplete="off"
                                       required="true" placeholder="Имя" style="color: #555">
                            </div>
                            <p class="text_details">Латинскими буквами,как в паспорте</p>
                        </div>
                        <div class="col_group-mb-12">
                            <div class="wrapper">
                                <input type="date" name="datetime" autocomplete="off" class="data" placeholder=" ">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel_form_group">
                    <div class="panel_form_group_data">
                        <div class="data"><strong>Паспортные данные</strong></div>
                    </div>
                    <div class="col_group">
                        <div class="col_group-mb-12">
                            <div class="wrapper ui-link dropdown">
                                <input type="text" class="input_data" name="passport" autocomplete="off"
                                       placeholder="Серия и номер паспорта" style="color: #555">
                            </div>
                        </div>
                    </div>

                </div>
                <div class="panel_form_group">
                    <div class="panel_form_group_data">
                        <div class="data"><strong>Контактная информация</strong></div>
                    </div>
                    <div class="col_group">
                        <div class="col_group-mb-12">
                            <div class="wrapper ui-link dropdown">
                                <input type="text" class="input_data" name="numberPhone" autocomplete="off"
                                       placeholder="Номер телефона" style="color: #555">
                            </div>
                        </div>
                        <div class="col_group-mb-12">
                            <div class="wrapper ui-link dropdown">
                                <input type="Email" class="input_data" name="email" autocomplete="off"
                                       placeholder="Email" style="color: #555">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel_form_group">
                    <div class="panel_form_group_data">
                        <div class="data"><strong>Адрес</strong></div>
                    </div>
                    <div class="col_group">
                        <div class="col_group-mb-12">
                            <div class="wrapper ui-link dropdown">
                                <input type="text" class="input_data" name="city" autocomplete="off" placeholder="Город"
                                       style="color: #555">
                            </div>
                        </div>
                        <div class="col_group-mb-12">
                            <div class="wrapper ui-link dropdown">
                                <textarea class="data_about_adress" autocomplete="off" name="adress" placeholder="Адрес"
                                          style="color: #555" rows="4" cols="25"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel_form_group">
                    <div class="panel_form_group_data">
                        <div class="data"><strong>Пароль</strong></div>
                    </div>
                    <div class="col_group">
                        <div class="col_group-mb-12">
                            <div class="wrapper ui-link dropdown">
                                <input type="password" minlength="6" maxlength="20" class="input_data" name="password" autocomplete="off"
                                       required="true" placeholder="Введите пароль" style="color: #555"
                                       style="color: #555">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="button_register">
                    <div class="panel_form_group_data">
                        <div class="col-mb-12 col-4_form-group">
                            <button type="submit" id="registr_button">Зарегистрироваться</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
