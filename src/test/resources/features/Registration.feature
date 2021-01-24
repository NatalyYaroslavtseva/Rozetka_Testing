Feature: As a user I want to register on the website

  Scenario Outline: Registration with incompletely filled fields
    Given The user open Rozetka website
    When The user open the registration form
    And The user fill fields:
      | name     | <name>     |
      | surname  | <surname>  |
      | password | <password> |
    And The user fill 'Phone' field and click on 'email' field
  #Then
    Examples:
      | name | surname | password |
      | Иван | Иванов  | Ivan11   |




#2) Не правильна реєстрація
#Відкрити сайт https://rozetka.com.ua/
#"увійдіть в особистий кабінет"
#"Зареєструватися"
#Ввести прізвище/ім'я/ випадкове 10-значне число / пароль
#Перевірити наявність помилки "Введіть свою ел. пошту або телефон"