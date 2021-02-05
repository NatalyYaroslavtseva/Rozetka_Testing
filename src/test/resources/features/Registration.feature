Feature: As a user I want to register on the website

  Scenario Outline: Registration with incompletely filled fields
    Given The user open Rozetka website
    When The user open the registration form
    Then The user check the 'Registration Form page' is invoked
    And The user fill fields:
      | name     | <name>     |
      | surname  | <surname>  |
    And The user fill 'Phone' field and click on 'email' field
    And The user click on the 'Register' button
    Then The user check the 'Registration Form page' is invoked
    Then The user check that proper error message under the 'email' field is displayed:
      """
      Введіть свою ел. пошту
      """
    When The user click on the 'password' field
    And The user click on the 'Register' button
    Then The user check the 'Registration Form page' is invoked
    Then The user check the 'password' field is error-highlighted
    Examples:
      | name | surname |
      | Иван | Иванов  |




#2) Не правильна реєстрація
#Відкрити сайт https://rozetka.com.ua/
#"увійдіть в особистий кабінет"
#"Зареєструватися"
#Ввести прізвище/ім'я/ випадкове 10-значне число / пароль
#Перевірити наявність помилки "Введіть свою ел. пошту або телефон"