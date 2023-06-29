# MoneyCorp

**Selenium Java Automation project with POM Design Pattern using TestNG Framework**

*This repository contains a sample project that demonstrates Selenium automation using Java, following the Page Object Model (POM) design pattern. It utilizes the TestNG framework for test execution.*

#Table of Contents
- Introduction
- Prerequisites
- Setup
- Project Structure
- Usage
- Writing Tests
- Running Tests

# Introduction
Selenium is a popular open-source automation tool used for automating web browsers. It provides a rich set of APIs and supports various programming languages. This project demonstrates how to use Selenium with Java to create maintainable and scalable test automation code by following the POM design pattern. The POM design pattern helps in creating a structured and modular test automation framework.

# Prerequisites
To run this project, you need to have the following installed on your system:

- Java Development Kit (JDK) - version 8 or above
- Maven - build automation tool
- Selenium WebDriver - Java bindings
- TestNG - testing framework
- ChromeDriver - WebDriver for Chrome (or other appropriate WebDriver for your browser)

# Setup
- Clone this repository to your local machine.
- Ensure you have the prerequisites installed.
- Update the pom.xml file with the necessary dependencies.

Make sure you have a compatible web browser installed (e.g., Chrome) for WebDriver to control.
Update the test configuration file or add any necessary environment-specific configurations.

# Project Structure
The project follows a standard Maven project structure with the addition of test-related packages and files. Here's an overview of the important directories and files:

- src/main/java: Contains the main source code of the project.
- com.mc.base: Contains a base test class for driver initialization, configuration reader, etc.,
- com.mc.libraries: Contains classes with Common methods, Page specific methods etc.,
- com.mc.pages: Contains page object classes representing different pages or components of the application.
- com.mc.utils: Contains utility classes like Listeners, Retry Analyzer etc.,
- com.mc.tests: Contains test classes that utilize the page objects to perform test actions.
- src/test/java: Contains the test-related code.
- src/main/resources: Contains the log4j configuration file.
- src/test/resources: Contains the application / configuration properties file.
- pom.xml: The project's Maven configuration file that manages project dependencies and build settings.
- testng.xml: This file, providing TestNG XML configuration file, which defines the test suite and test configurations.
- README.md: This file, providing an overview and instructions for the project.

# Usage
To use this project as a starting point for your Selenium automation, follow these steps:

- Set up the prerequisites as mentioned earlier.
- Clone or download this repository to your local machine.
- Customize the project according to your application under test.
- Write your test cases by creating page object classes and test classes.
- Update the test configuration in the testng.xml file.
- Build and execute the tests using Maven and TestNG.

# Writing Tests
When writing tests in this project, adhere to the following guidelines:

- Create page object classes under the pages package, representing different pages or components of the application.
- Implement the methods in the page object classes or maintain separate class methods to interact with the web elements on the page.
- Create test classes under the tests package to write individual test cases.
- Use TestNG annotations (e.g., @Test, @BeforeMethod, @AfterMethod, etc.) to define the test behavior and order.
- Utilize the page object classes to perform test actions and verifications.
- Leverage the classes in the library package for common functionalities.
- Leverage the utility classes in the utils package for Listeners, Retry Analyzer functionalities.

# Running Tests
To run the tests, follow these steps:

- Open a terminal or command prompt.
- Navigate to the project directory.
- Execute the command mvn clean test. Maven will build the project, run the tests, and generate the test reports.
