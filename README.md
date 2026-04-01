# Hybrid Automation Framework

## Overview
This is a hybrid automation framework designed for web application testing. It integrates Selenium WebDriver, TestNG, and other tools to provide a robust and scalable testing solution.

## Features
- Cross-browser testing support (Chrome, Edge).
- Thread-safe WebDriver management.
- Modular design with Page Object Model (POM).
- TestNG integration for test execution and reporting.
- ExtentReports for detailed test reports.
- Apache POI for Excel file handling.

## Prerequisites
- Java 8 or higher
- Maven
- Supported browsers (Chrome, Edge)

## Setup
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd Hybrid_Automation_Framework
   ```
3. Install dependencies:
   ```bash
   mvn clean install
   ```

## Configuration
- Update the `config.properties` file with the desired browser and other settings.

## Running Tests
- Execute tests using Maven:
  ```bash
  mvn test
  ```
- Execute tests using TestNG:
  ```bash
  mvn test -DsuiteXmlFile=testng.xml
  ```

## Reports
- TestNG reports are generated in the `test-output` folder.
- ExtentReports are generated in the `reports` folder.

## CI/CD with Jenkins

This project includes a Jenkins pipeline for automated build and test execution. To use Jenkins:

1. Ensure Jenkins is installed and has the required plugins (Pipeline, Maven Integration, JUnit, etc.).
2. Create a new Pipeline job and point it to this repository.
3. The included `Jenkinsfile` will:
    - Check out the code
    - Build the project with Maven
    - Run TestNG tests
    - Archive and publish test results

You can view and customize the pipeline in the `Jenkinsfile` at the root of this project.

## Contributing
Feel free to contribute by submitting issues or pull requests.

## License
This project is licensed under the MIT License.