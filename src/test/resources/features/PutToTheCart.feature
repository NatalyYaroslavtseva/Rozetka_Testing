Feature: As a user I want to put into a cart a product that I was looking for

  Scenario Outline: Putting to the cart a product founded by using search-field
    Given The user open Rozetka website
    When The user enter to the search-field <search_input> and click Enter
    And The user open first product from found products
    Then The title of the product should contain <search_input>
    When The user click on the 'Buy' button
    Then The cart is opened
    Examples:
      | search_input                    |
      | 'Apple iPhone 12 Pro Max 256 GB' |

  #1) Покупка
  #Відкрити сайт https://rozetka.com.ua/
  #Ввести в пошук Apple iPhone 12 Pro Max 256GB
  #Відкрити перший знайдений продукт і перевірити наявність пошукового запиту в назві
  #Натиснути "Купити" та перевірити відкриття вікна корзини
