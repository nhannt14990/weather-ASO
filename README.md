# Introduction
WeatherApp - This application will return current weather data from OpenWeatherMap.org, based on a city chosen by the user.

# Source of Data
Weather data is read from http://openweathermap.org/ using API http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}

# Pre-requisite
To use this app, you need to register an API Key on http://openweathermap.org/ service.
Update api key in src/main/resources/application.properties

Import database MySQL.

# How to run
This app has embedded tomcat server. In order to run this website execute below maven command
mvn spring-boot:run
Or run by java services https://wrapper.tanukisoftware.com/doc/english/download.jsp
Or open project, open WeatherApplication and run spring boot app.

It will start the embedded tomcat server on default port 8080

# How to Use
- Access the website using http://localhost:8080
- Enter city name and click search to show city in table.
- Click delete in row of table to delete record.
- Click Weather in row of table to call api get weather from OpenWeatherMap and show infomation in form, click show more for get list weather of city.
- Click Add new city to add city.
- Click Search weather to search weather by name of city


# TODO
- Java Doc
- Form Level Validation
- Message Resourcing
