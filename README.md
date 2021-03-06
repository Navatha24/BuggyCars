# BuggyCars Testing

## Application Under Test
* https://buggy.justtestit.org

## Testing Types in Scope

* Functional Testing


## Test Approach

* Functional testing for BuggyCars application will be carried out by an agile development team using Specification By Example (SBE) or Behaviour Driven Development (BDD) approach. 
* Functionality or expected behaviour of the application is specified by defining features and specifications.
* High level acceptance criteria for a feature should be defined by the business representative even before writing specifications.
* After the acceptance criteria is defined, agile development team collaborates to write and review specifications using a domain specific language (DSL). These specifications are expressed in the form of testable scenarios
and any misunderstandings or assumptions related to the feature are clarified while writing these scenarios.
* Specifications written are then translated into automated scenarios using a BDD Cucumber framework (https://en.wikipedia.org/wiki/Cucumber_(software)). These automated scenarios are integrated into CI/CD pipeline to achieve continuous delivery.

## Features

1. Login
2. Logout
3. Register
4. Profile - Save
5. Cars Ranking

## Sample Feature
```
Feature: Login
  As a Buggy Cars Rating existing user
  I want to login
  so that I can view buggy ratings

  
  Scenario Outline: Successful login
    Given am on BuggyRates loginpage
    And I enter username "<username>" and password
    When I login
    Then am logged in successfully
    Examples:
      | username |
      | admin    |
      | admin2   |
```
## Prerequisites

* Mac Operating System
* Java 8
* Maven 3+
* IntelliJ IDEA
* Google Chrome ```Version 88.0.4324.192 (Official Build) (x86_64)``` and chrome webdriver ```ChromeDriver 88.0.4324.96``` ```npm install chromedriver && chromedriver --version```
* Any command line terminal (iTerm2 for Mac)

## Run tests using maven

* Clone the repo in github directory on your computer

    ```git clone https://github.com/Navatha24/BuggyCars.git```

* Use Maven to install dependencies and run tests using command line terminal

    ````
    cd BuggyCars
    ./mvnw test or mvn clean install or mvn clean test
    ````
This runs Cucumber features using Cucumber's JUnit test runner. The @RunWith(Cucumber.class) annotation on the RunCukeTest class in test runner folder tells JUnit to kick off Cucumber.

* Run a subset of Features or Scenarios using command line terminal

```` 
mvn -Dcucumber.options="src/test/resources/features/login.feature"
mvn test -Dcucumber.options="--tags @login"
mvn test -Dcucumber.options="--tags @login,@register"
````
## Living Documentation

* Generate a pdf living documentation for this application 
```
 mvn cukedoctor:execute
 ```
* Generated pdf document at ```/path/to/target/docs```

## Run tests using IntelliJ

* Using IntelliJ import cloned buggycars project
* Goto ```IntellijIDEA>Preferences>Plugins```. Install cucumber support plugin ```Cucumber for Java```
* Run tests using RunCukeTest class in testrunner folder

