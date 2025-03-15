
Feature: Add to cart and place order 
Scenario Outline: user places order of desired products with desired quantity
Given user is on Green kart landing page
When user searches for <product> and adds it to the cart with quantity <quantity>
Then the cart should display <product> with quantity <quantity>
And user places the order
Examples:
  | product   | quantity|
  | Carrot    | 4       |
  | Beetroot  | 3       |
  
  
  
@OrderUsingExcelData 
Scenario: user places order of desired products with desired quantity
Given user is on Green kart landing page
When user searches for product from excel_file and adds it to the cart with desired quantity
