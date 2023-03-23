<h1 align="center">Анализатор погоды</h1> 
<h2> Tools</h2>
Java(17), Spring Framework(Boot, Data JPA), Hibernate, MySQL, Maven, Lombok, SLF4J, REST, OpenWeatherMap API.

- Дает информацию о последней записи о погоде в БД http://localhost:8080/current
-![ime](https://github.com/OlyaEna/weather_api/blob/master/src/main/resources/static/img/current.JPG)
- Информация о среднесуточной температуре, рассчитанная на основании имеющихся в сервисе данных (через request)
-![ime](https://github.com/OlyaEna/weather_api/blob/master/src/main/resources/static/img/post.JPG)
- Дополнительная реализация через @GetMapping
Информация о среднесуточной температуре, рассчитанная на основании имеющихся в сервисе данных
-![ime](https://github.com/OlyaEna/weather_api/blob/master/src/main/resources/static/img/get.JPG)

<h2> Условие</h2>
Необходимо разработать анализатор погоды. Нужно использовать сторонние API (например https://rapidapi.com/weatherapi/api/weatherapi-com). Приложение будет запрашивать погоду с заданной в настройках периодичностью по определенному городу.

Как это работает:

Приложение получает информацию о погоде в Минске от стороннего API, по расписанию и сохраняет ее в БД.
(Город по которому запрашивается погода всегда один и тот же)

Первый endpoint должен в качестве ответа отдавать информацию о текущей погоде - наиболее актуальная информация, которая хранится в БД сервиса. В ответе должна содержаться следующая информация:

1) Температура
2) Скорость ветра в м/ч
3) Атмосферное давление в гектопаскалях или миллибарах
4) Влажность воздуха
5) Погодные условия (солнечно, облачно и т.д.)
6) Локация

Второй endpoint должен выдавать рассчитанную на основании имеющихся в сервисе данных информацию о среднесуточной температуре. Пользователь должен будет иметь возможность получить информацию за указанный период.

Request
{
“from”: “22-08-2021”,
“to”: “24-08-2021”
}
Response
{
“average_temp”: 10
// и другие
}
Взаимодействие пользователя с приложением происходит через REST API.

Требования:
приложение должно быть реализовано на языке Java версии 8+ ;
код должен соответствовать принципам Low Coupling и принципам ООП;
код должен соответствовать Java code style (именование переменных, структура класса и др.);
приложение должно содержать качественную обработку ошибок;
использовать Spring Framework(Spring Boot);
покрытие unit тестами(опционально, но будет плюсом);
вместе с приложением должны содержаться скрипты для создания схемы БД;
