# Foodics-Test
Automation Task For Foodics

## Introduction

This repository contains an automation script for keyword search, Navigation and some validations. 

## Prerequisites

To The main Frameworks included in the project:

-   [Java](https://www.java.com/en/download/) (version 8 or higher)
-   [Maven](https://maven.apache.org/install.html) (for building and running the Selenium scripts)
-   [TestNG](https://testng.org/doc/download.html) (for running the Selenium scripts)
-   [Selenium](https://www.selenium.dev/downloads/) (for automating the web browser)
 
## Design implementation:
- **Page Object Model**
- **Page Factory**


## Running the Selenium scripts

To run the Selenium scripts, follow these steps:

1.  Clone this repository to your local machine.
2.  Open the project with intellij IDE
3.  Open terminal in intellij
4. `mvn clean install`
5. Right Click on testing.xml
6. Select Run '.../testing.xml' 

## Task  (Testing framework: Selenium in Java)
### The task involves automating the following scenario on the Google website:


1. Open https://www.google.com and search for any keyword
2. Remove the keyword and search for a new one
3. Assert that number of results exist on UI
4. Scroll down and go to the next page
5. Validate if the number of results on page 2 is equal to page 3 or not
6. Validate there are different search suggestions displayed at the end of the page
7. Close the browser window

## Improtant Note
**To change Browser, URL, First Keyword, Second Keyword is from "src/main/java/resources/data.properties"**


## Authors

-   **Mostafa Mohamed AbdelRahman** 
