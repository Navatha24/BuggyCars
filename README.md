# BuggyCars Testing


## Prerequisites

* Java 8
* Maven
* IntelliJ IDEA
* IntelliJ IDEA Cucumber plugin

## Get the source code

Git:

    git clone 
    cd 

## Use Maven

Open a command window and run:

    ./mvnw test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the 
`RunCucumberTest` class tells JUnit to kick off Cucumber.


## Overriding options

Using Maven:

    mvn -Dcucumber.features="..." -Dcucumber.glue="..." test

For available options and overriding rules, please consult the following Maven command:

    mvn exec:java \
      -Dexec.classpathScope=test \
      -Dexec.mainClass=io.cucumber.core.cli.Main \
      -Dexec.args="--help"

### Run a subset of Features or Scenarios

Specify a particular scenario by *line*

    -Dcucumber.features="classpath:skeleton/belly.feature:4"

This works because Maven puts `./src/test/resources` on your `classpath`.
You can also specify files to run by filesystem path:

    -Dcucumber.features="src/test/resources/skeleton/belly.feature:4"

In case you have many feature files or scenarios to run against, separate them with commas `,`

    -Dcucumber.features="src/test/resources/skeleton/belly.feature:4, src/test/resources/skeleton/stomach.feature"

You can also specify what to run by *tag*:

    -Dcucumber.filter.tags="@bar"

### Running only the scenarios that failed in the previous run

    -Dcucumber.features="@target/rerun.txt"

