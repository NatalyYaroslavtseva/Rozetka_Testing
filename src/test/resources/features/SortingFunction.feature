Feature: As a user I want to check working of sorting function

  Scenario Outline: The function of sorting by price of search result products is working
    Given The user open Rozetka website
    When The user enter to the search-field <search_input> and click Enter
    And The user sort products by price ascending
    Then The products are sorted by price ascending
    When The user sort products by price descending
    Then The products are sorted by price descending
    Examples:
      | search_input                    |
      | 'Apple iPhone 12 Pro Max 256GB' |


  #4) Сортування
  #Відкрити сайт https://rozetka.com.ua/
  #Ввести в пошук Apple iPhone 12 Pro Max 256GB
  #Перевірити сортування
  #від дорогих до дешевих
  #і навпаки