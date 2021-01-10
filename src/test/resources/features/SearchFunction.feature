Feature: As a user I want to check working of search function

  Scenario Outline: The search result of non-existent products is empty
    Given The user open Rozetka website
    When The user enter to the search-field <search_input> and click Enter
    Then No products is shown in search result
    Examples:
      | search_input        |
      | 'синхрофазотрон'    |
      | 'зілля невидимості' |
      | 'індульгенція'      |



  #3) Пустий пошук
  #Відкрити сайт https://rozetka.com.ua/
  #Знайти продукти:
  #синхрофазотрон
  #зілля невидимості
  #індульгенція
  #Впевнитись у відсутності результатів пошуку