@search
Feature: Search and place the order for products
Scenario Outline: Validating search results in home page and Top Deals Page
Given user is on Green kart landing page
When User search with short name <Name> in home page search and extracted result
Then user search with same short name <Name>  in top deals page to check if product exists
And validating whether price displayed is same in both the pages
Examples:
    |Name|
    |Tom|
    |Beet|
    |Pot|
    
   
@SearchUsingExcelData
Scenario: Validating search results in home page and Top Deals Page using exceldata
Given user is on Green kart landing page
When User searched with short name from excel_file in home page search and extracted result
Then user search with same short name <Name>  in top deals page to check if product exists
And validating whether price displayed is same in both the pages
   

    
       