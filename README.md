# Green Kart Automation Testing Project

## Overview

This project is focused on automating the testing of **Green Kart**, an e-commerce platform. It includes automating key features such as adding products to the cart, placing orders, and validating search results on both the homepage and top deals page.

The tests are written in **Cucumber** (using **Gherkin** syntax) for behavior-driven development (BDD), combined with **Selenium** for web automation, and **TestNG** for test execution and reporting. The data for certain tests is driven by **Excel** files, making the test execution dynamic and flexible.

## Features

- **Add to Cart and Place Order**: Automates the process of searching for a product, adding it to the cart with a specified quantity, and placing the order. It also checks that the cart reflects the correct quantity of the product.
- **Product Search Validation**: Validates the search functionality between the homepage and the top deals page to ensure consistent results and prices.
- **Data-Driven Testing Using Excel**: Loads product names and quantities from Excel files to run multiple variations of the same test.

## Technologies Used

- **Java**: Primary programming language for test scripts.
- **Selenium WebDriver**: For browser automation and interacting with web elements.
- **Cucumber**: For writing BDD-style feature files and executing tests.
- **TestNG**: For managing and executing tests, including test grouping and parallel execution.
- **Apache POI**: To read data from Excel files for data-driven testing.
- **Maven**: For project dependency management and build automation.
- **Git**: For version control.

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Java JDK 8+**: [Download here](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- **Maven**: [Download here](https://maven.apache.org/download.cgi)
- **Eclipse/IntelliJ IDEA**: Integrated Development Environment (IDE) for writing and running tests.

## Project Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/green-kart-automation.git
  
