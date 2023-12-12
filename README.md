# Demo Project - Hostaway Tech Assignment

## Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [Setup and Installation](#setup-and-installation)
  - [Requirements](#requirements)
  - [Maven Installation](#maven-installation)
    - [Windows](#windows)
    - [Mac](#mac)
  - [Allure Command Line Tools Installation](#allure-command-line-tools-installation)
    - [Windows](#windows-1)
    - [Mac](#mac-1)
- [Configuration](#configuration)
- [Usage](#usage)
- [Project Directory Structure](#project-directory-structure)

## Overview
This project is a UI testing framework utilizing the Selenide library to automate and validate the functionality of web applications, designed specifically for the requirements of this technical assignment.

## Key Features

- **Selenide Integration:** The framework leverages the Selenide library to enhance the simplicity and efficiency of UI test automation.

- **Maven-based Project:** Built on Maven for easy project management, dependency resolution, and build automation.

- **Allure Reporting:** Allure is integrated for comprehensive and visually appealing test reports, providing insights into test execution and results.

- **TestNG Integration:** TestNG is utilized for test management, parallel execution, and reporting.


## Setup and Installation

### Requirements
- Java 11
- Maven
- Allure Command Line Tools

### Maven Installation

#### Windows
1. Download Maven from the official website: [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract the downloaded archive to a directory of your choice.
3. Add the Maven `bin` directory to the system `PATH` variable.
   Example:
   ```bash
   set PATH=%PATH%;C:\path\to\apache-maven-3.x.x\bin

#### Mac
1. Install Homebrew if not already installed: Homebrew
2. Open a terminal and run the following command to install Maven:
   Example:
   ```bash
   brew install maven


### Allure Command Line Tools Installation

#### Windows
1. Download Allure Command Line Tools from the official repository: Allure Command Line
2. Extract the downloaded archive to a directory of your choice.
3. Add the Allure bin directory to the system PATH variable.
Example:
   ```bash
   set PATH=%PATH%;C:\path\to\allure-commandline-2.x.x\bin

#### Mac
1. Open a terminal and run the following commands to install Allure:
   ```bash
   brew tap allure-framework/allure
   brew install allure

## Configuration

The project uses a configuration file `config.properties` to manage various settings. Below are the key configurations:

### Common Configuration

- **Retry Count:**
  - The `retrycount` property is set to control the number of times a test should be retried in case of failures. Adjust this value according to your requirements.
  ```properties
  retrycount=2

### Browser Configuration

- **Browser Type:**
  - The 'browser.type' property determines the type of browser used for test execution (e.g., chrome, firefox).
  - The 'browser.version' property specifies the version of the browser to use.
  - The 'browser.size' property sets the initial size of the browser window.
  - The 'browser.headless' property, if set to true, enables running the browser in headless mode, without a graphical interface.
  - The 'browser.timeout' property defines the maximum time (in milliseconds) to wait for browser-related actions.
  ```properties
  browser.type=chrome
  browser.version=116
  browser.size=1920x1080
  browser.headless=false
  browser.timeout=30000

### Test Configuration

- **Demo Domain URL:**
  - The 'demo.domain.url' property contains the URL of the demo domain to be used for testing.
  ```properties
  demo.domain.url=https://kamil-demo.alpinizm.uz/

**Adjust these configurations in the config.properties file based on your testing environment and requirements.**

### Environment Properties
**These values are added dynamically upon test execution, and is based off a combination of your system properties and values set in your config.properties file. There is no need to edit any values in this file.**


## Usage

To use this project, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/your-project.git
   
2. Navigate to the Project Directory:
    ```bash
    cd your-project

3. Build the Project with Maven:
    ```bash
    mvn clean install
   
4. Run Tests with Maven:
    ```bash
    mvn clean test
   
5. Generate Allure Reports:
    ```bash
    allure serve
   
6. Customize Test Suite:

   Customize the test suite by modifying the XML files in the src/test/resources/suites/ directory.

## Project Directory Structure
```css
project-root
│
├── allure-results
├── src
│   ├── main
│   │   └── java
│   │       └── ... (main source code)
│   ├── test
│   │   └── java
│   │       └── ... (test source code)
│   │       └── resources
│   │           └── suites
│   │               └── all_tests.xml (TestNG suite file)
│   │           └── ... (configuration files, e.g., *.properties)
│   └── ...
├── target
├── pom.xml
├── README.md
└── ...