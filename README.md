# BuggyCars Testing

## Application
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

## Prerequisites

* Operating System (Tested on Mac)
* Java 8
* Maven
* IntelliJ IDEA
* IntelliJ IDEA Cucumber plugin

## Run tests

* Clone the repo in github directory on your computer

    ```git clone https://github.com/Navatha24/BuggyCars.git```


* Install the maven dependencies

    ````
    cd BuggyCars
    mvn clean install
    ````
* Run the tests
    ```mvn clean test```

  