# Noon.com Guest User Test Automation

Automated test suite for validating key guest-user (not-logged-in) flows on [Noon.com](https://www.noon.com/), built with **Selenium WebDriver** and **Cucumber (BDD)**, using **data-driven testing (DDT)** with **Excel** and **CSV** as data sources.

## Overview

- **Website Under Test:** https://www.noon.com/
- **Testing Framework:** Cucumber (BDD) with TestNG runner
- **Precondition:** All tests run as a guest user (no login/authentication required)
- **DDT Sources:** Excel (`.xlsx`), CSV

## Test Scenarios

### 1. Browse and Filter Products
Verifies that a user can navigate to the Electronics category, apply filters (Brand = Samsung, Price range = 1000–3000 EGP), sort by Customer Ratings, and confirm the listed items match the applied filters and sorting.

### 2. Add Multiple Products to Cart (Guest)
Verifies that a guest user can search for "Headphones", select 3 different items, add them to the cart, and confirm all 3 items appear with the correct price and quantity.

### 3. Guest Checkout Flow
Verifies the end-to-end guest checkout process: proceeding to checkout, selecting "Checkout as Guest," entering a valid delivery address, choosing Cash on Delivery, and confirming the order summary before placing the order.

### 4. Search Validation with Invalid Input
Verifies that entering an invalid/nonsensical search string (e.g. `###xyz123!!!`) correctly returns a "No results found" message with no unrelated items displayed.

## Project Structure

```
├── src
│   ├── main
│   │   └── java
│   │       └── pages/          # Page Object Model classes
│   └── test
│       ├── java
│       │   ├── BaseTest/
│       │   ├── Category/
│       │   ├──Data/ # Excel & CSV test data files
│       │   ├──Drivers/
│       │   ├──Filteration/
│       │   ├──Hooks/
│       │   ├──Invoice/
│       │   ├──Screenshots/
│       │   ├──AddProductsToCart/
│       └── resources
├── pom.xml
└── README.md
```

## Prerequisites

- Java JDK 11+
- Maven
- IntelliJ IDEA (or any Java IDE)
- Chrome/Firefox browser + matching WebDriver (or WebDriverManager dependency)

## Setup & Running Tests

1. Clone the repository:
   ```bash
   git clone <https://github.com/MazenTarek20/Automation_Framework_Cucumber>
   ```
2. Open the project in IntelliJ IDEA as a Maven project.
3. Let Maven resolve dependencies from `pom.xml`.
4. Update test data in the Excel/CSV files under `src/test/resources/testdata/`.
5. Run tests via the Cucumber runner class (in `runners/`) or directly through IntelliJ's Cucumber plugin by right-clicking a `.feature` file.

## Data-Driven Testing (DDT)

Test data for all scenarios is externalized using:
- **Excel** — read via Apache POI
- **CSV** — read via a custom CSV parser / OpenCSV

This allows test scenarios to be re-run with multiple data sets without changing the test code.

## Notes

- All scenarios are executed as a **guest user**; no login credentials are required.
- Update the `testdata` files to add new filter combinations, search terms, or delivery addresses as needed.
